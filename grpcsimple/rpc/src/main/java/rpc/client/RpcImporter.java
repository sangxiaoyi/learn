package rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 本地服务代理
 * 将本地的接口调用转成JDK的动态代理，在动态代理中实现接口的远程调用
 * 创建Socket客户端，根据指定地址链接远程服务者
 * 将远程服务调用所需要的接口类，方法名，参数类表等编码参数发送给服务提供者
 * 同步阻塞等待服务端返回应答，获取应答之后返回
 * @author
 * @Description
 * @date
 */
public class RpcImporter<S> {
    @SuppressWarnings("unchecked")
    public S importer(final Class<?>serviceClass, final InetSocketAddress address){
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{
                serviceClass.getInterfaces()[0]
        }, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;
                ObjectOutputStream outputStream = null;
                ObjectInputStream inputStream = null;
                try{
                    socket = new Socket();
                    System.out.println("创建客户端socket，并请求连接");
                    socket.connect(address);
                    //将远程服务调用所需要的接口类、方法名、参数列表等编码参数发送给服务提供者
                    System.out.println("客户端发送请求数据");
                    outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeUTF(serviceClass.getName());
                    outputStream.writeUTF(method.getName());
                    outputStream.writeObject(method.getParameterTypes());
                    outputStream.writeObject(args);
                    //同步阻塞等待服务端返回应答，获取应答之后返回
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    return inputStream.readObject();
                }finally {
                    if(socket != null){
                        socket.close();
                    }
                    if(outputStream != null){
                        outputStream.close();
                    }
                    if (inputStream != null){
                        inputStream.close();
                    }
                }
            }
        });
    }
}
