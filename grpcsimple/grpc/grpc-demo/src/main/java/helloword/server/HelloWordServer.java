package helloword.server;

import helloword.server.impl.GreeterImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author
 * @Description
 * @date
 */
public class HelloWordServer {

    private static final Logger logger = Logger.getLogger(HelloWordServer.class.getName());

    private Server server;

    private void start() throws IOException{
        /* The port on which the server should run */
        int port  = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        logger.info("Server started,listening on "+port);

        //添加jvm钩子
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.out.println("*** shutting down gRPC server since JVM is shutting down");
                HelloWordServer.this.stop();
                System.err.println("*** server shut down");
            }
        });

    }

    private void stop(){
        if(server !=null){
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown()throws InterruptedException{
        if(server != null){
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static  void main(String[] args) throws IOException, InterruptedException {
        final HelloWordServer server = new HelloWordServer();
        server.start();
        server.blockUntilShutdown();

    }

}
