package helloStream;

import com.grpc.demo.proto.hellostream.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * 客户端代码实现
 * @author
 * @Description
 * @date
 */
public class GrpcCustomClient {
    private ManagedChannel channel;

    private ExampleGrpcGrpc.ExampleGrpcBlockingStub blockingStub;

    private  ExampleGrpcGrpc.ExampleGrpcStub asyStub;

    private void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException{
        GrpcCustomClient grpcCustomClient = new GrpcCustomClient();
        //创建通道channel
        grpcCustomClient.channel = ManagedChannelBuilder.forAddress("127.0.0.1",8086)
                .usePlaintext()
                .build();
        //通过通道获取stub
        grpcCustomClient.blockingStub = ExampleGrpcGrpc.newBlockingStub(grpcCustomClient.channel);

        //情况一
        Iterator<StudentResponse> listMessage = grpcCustomClient.blockingStub.getListMessage(HelloRequest.newBuilder().setNo("11").build());

        while (listMessage.hasNext()){
            StudentResponse studentResponse = listMessage.next();
            System.out.println(studentResponse.getName()+ ","+ studentResponse.getAge() + ","+ studentResponse.getCity());
        }
        System.out.println("----------------------------------------------------------");

        //情况二
        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getName());
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println("*************");
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }
        };

        //异步的桩
        grpcCustomClient.asyStub = ExampleGrpcGrpc.newStub(grpcCustomClient.channel);
        StreamObserver<HelloRequest> studentList = grpcCustomClient.asyStub.getStudentList(studentResponseListStreamObserver);

        //消息发送是异步的，如果客户端结束过快，可能还没有接收到消息就已经一结束了
        studentList.onNext(HelloRequest.newBuilder().setNo("15").build());
        studentList.onNext(HelloRequest.newBuilder().setNo("16").build());
        studentList.onNext(HelloRequest.newBuilder().setNo("17").build());
        studentList.onNext(HelloRequest.newBuilder().setNo("18").build());

        studentList.onCompleted();

        System.out.println("---------------------------------------------------------------------------");

        //第三种请求
        StreamObserver<StreamRequest> requestStreamObserver = grpcCustomClient.asyStub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());

            }

            @Override
            public void onCompleted() {
                System.out.println("completed");

            }
        });
        for (int i=0;i<10;i++){
            requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());
            TimeUnit.SECONDS.sleep(1);
        }

        //发送完毕通知
        requestStreamObserver.onCompleted();
        //关闭客户端
        grpcCustomClient.shutdown();

    }


}
