package helloword.server;

import com.grpc.demo.proto.helloword.HelloReply;
import com.grpc.demo.proto.helloword.HelloRequest;
import io.grpc.stub.StreamObserver;

/**
 * @author
 * @Description
 * @date
 */
public interface GreeterService {
    public void sayHello(HelloRequest request, StreamObserver<HelloReply>responseObserver);
}
