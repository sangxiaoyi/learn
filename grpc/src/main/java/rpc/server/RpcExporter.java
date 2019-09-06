package rpc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * RPC服务器发布者
 * 作为服务端，监听客户端的TCP连接，接收到新的客户端连接之后，将其封装成TASK，由线程池执行
 * 将客户端发送的码流反序列化成对象，反射调用服务实现着，获取执行结果
 * 将执行结果对象发序列化，通过socket发送给客户端
 * 远程调用完成之后，释放Socket等连接资源，防止句柄泄露
 * @author
 * @Description
 * @date
 */
public class RpcExporter {
    //创建一个可重用固定线程数的线程池
    //Runtime.getRuntime().avaliableProcessors()返回虚拟机可用的处理器数量
    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void exporter(String hostname,int port) throws IOException{
        //创建一个监听特定端口的Serversocket,负责接收客户连接请求
        ServerSocket serverSocket = new ServerSocket();
        //绑定主机名和端口号
        serverSocket.bind(new InetSocketAddress(hostname,port));
        System.out.println("服务端的socket已经启动，等待连接");
        try{
            while (true){
                System.out.println("接收客户端socket连接");
                executor.execute(new ExporterTask(serverSocket.accept()));
            }
        }finally {
            serverSocket.close();
        }
    }
    private static class ExporterTask implements Runnable{
        Socket client = null;
        public ExporterTask(Socket client){
            this.client = client;
        }

        public void run() {
            System.out.println("处理客户端的请求");
            ObjectInputStream inputStream = null;
            ObjectOutputStream outputStream = null;
            try{
                //获取输入流
                inputStream = new ObjectInputStream(client.getInputStream());
                //获取调用的接口名
                String interfaceName = inputStream.readUTF();
                //加载接口
                Class<?> service = Class.forName(interfaceName);
                //获取调用的方法名
                String methodName = inputStream.readUTF();
                //获取方法返回类型
                Class<?>[] ParameterType = (Class<?>[])inputStream.readObject();
                //获取参数
                Object[] arguments = (Object[])inputStream.readObject();
                //通过反射获取方法
                Method method = service.getMethod(methodName,ParameterType);
                //通过反射调用方法
                Object result = method.invoke(service.newInstance(),arguments);

                outputStream = new ObjectOutputStream(client.getOutputStream());
                System.out.println("结果返回给客户端");
                outputStream.writeObject(result);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(outputStream !=null ) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(inputStream !=null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (client !=null){
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
