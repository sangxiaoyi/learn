package helloStream;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * 服务端启动类
 * @author
 * @Description
 * @date
 */
public class GrpcCustomServer {

    private Server server;

    private void start() throws IOException {
        int port = 8086;
        server = ServerBuilder.forPort(port)
                .addService(new GrpcServerImpl())
                .build()
                .start();
        System.out.println("server start....");

        //添加jvm钩子
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("jvm将要关闭");
                stop();
                System.out.println("jvm关闭...");
            }
        }));
    }
    private void stop(){
        if(server != null){
            server.shutdown();
        }
    }

    private void blockServer() throws InterruptedException {
        if(server != null){
            server.awaitTermination();
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        GrpcCustomServer grpcCustomServer = new GrpcCustomServer();
        grpcCustomServer.start();
        //start方法是异步的，所以这里要把服务器阻塞，不然主程序就结束了
        grpcCustomServer.blockServer();

    }
}
