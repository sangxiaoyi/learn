package helloStream;

import com.grpc.demo.proto.hellostream.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * 自定义服务端实现类
 * @author
 * @Description
 * @date
 */
public class GrpcServerImpl extends ExampleGrpcGrpc.ExampleGrpcImplBase {
    /**
     * 客户端发送消息，服务端返回流
     * @param request
     * @param responseStreamObserver
     */
    @Override
    public void getListMessage(HelloRequest request, StreamObserver<StudentResponse>responseStreamObserver){
        System.out.println("服务端接收到的消息是："+request.getNo());
        responseStreamObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(18).setCity("西安").build());
        responseStreamObserver.onNext(StudentResponse.newBuilder().setName("李四").setAge(20).setCity("北京").build());
        responseStreamObserver.onNext(StudentResponse.newBuilder().setName("王五").setAge(38).setCity("上海").build());
        responseStreamObserver.onCompleted();
    }

    /**
     * 客户端发送流，服务端返回消息
     * @param responseListStreamObserver
     * @return
     */
    @Override
    public StreamObserver<HelloRequest> getStudentList(StreamObserver<StudentResponseList> responseListStreamObserver){
        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest value) {
                System.out.println("onNext:"+value.getNo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError:"+t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse studentResponse1 = (StudentResponse.newBuilder().setName("张三").setAge(18).setCity("西安").build());
                StudentResponse studentResponse2 = (StudentResponse.newBuilder().setName("李四").setAge(20).setCity("北京").build());
                StudentResponseList studentResponseList = StudentResponseList.newBuilder().addStudentResponse(studentResponse1).addStudentResponse(studentResponse2).build();
                responseListStreamObserver.onNext(studentResponseList);
                responseListStreamObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse>responseStreamObserver){
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseStreamObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                //客户端连接关闭，服务端也要把连接关闭，否则保留一个单向流没有意义
                responseStreamObserver.onCompleted();
            }
        };
    }
}
