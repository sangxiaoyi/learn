package helloword.server.impl;

import com.grpc.demo.proto.helloword.GreeterGrpc;
import com.grpc.demo.proto.helloword.HelloReply;
import com.grpc.demo.proto.helloword.HelloRequest;
import helloword.server.GreeterService;
import io.grpc.stub.StreamObserver;

/**
 * @author
 * @Description
 * @date
 */
public class GreeterImpl extends GreeterGrpc.GreeterImplBase implements GreeterService {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver){
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello "+request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
