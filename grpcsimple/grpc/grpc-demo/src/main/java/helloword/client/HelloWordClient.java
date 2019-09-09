package helloword.client;

import com.grpc.demo.proto.helloword.GreeterGrpc;
import com.grpc.demo.proto.helloword.HelloReply;
import com.grpc.demo.proto.helloword.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author
 * @Description
 * @date
 */
public class HelloWordClient {
    private static final Logger logger = Logger.getLogger(HelloWordClient.class.getName());

    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public HelloWordClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    HelloWordClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutsown() throws InterruptedException{
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Say hello to server. */
    public void greet(String name){
        logger.info("will try to greete "+name+" ....");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try{
            response = blockingStub.sayHello(request);
        }catch (StatusRuntimeException e){
            logger.log(Level.WARNING,"RPC failed:{0}",e.getStatus());
            return;
        }
        logger.info("client recived message : "+response.getMessage() );
    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception{
//        HelloWordClient client1  = new HelloWordClient();
//        //创建通道channel
//        client1.channel = ManagedChannelBuilder.forAddress("127.0.0.1",50051)
//                .usePlaintext()
//                .build();
//        //通过通道获取stub
//        client1.blockingStub = GreeterGrpc.newBlockingStub(client1.channel);
        HelloWordClient client  = new HelloWordClient("localhost",50051);
        try {
            /* Access a service running on the local machine on port 50051 */
            String user = "yoyo";
            client.greet(user);
        }finally {
            client.shutsown();
        }



    }
}
