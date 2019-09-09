package com.grpc.demo.proto.hellostream;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: helloStream.proto")
public final class ExampleGrpcGrpc {

  private ExampleGrpcGrpc() {}

  public static final String SERVICE_NAME = "hellostream.ExampleGrpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.HelloRequest,
      com.grpc.demo.proto.hellostream.StudentResponse> getGetListMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListMessage",
      requestType = com.grpc.demo.proto.hellostream.HelloRequest.class,
      responseType = com.grpc.demo.proto.hellostream.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.HelloRequest,
      com.grpc.demo.proto.hellostream.StudentResponse> getGetListMessageMethod() {
    io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.HelloRequest, com.grpc.demo.proto.hellostream.StudentResponse> getGetListMessageMethod;
    if ((getGetListMessageMethod = ExampleGrpcGrpc.getGetListMessageMethod) == null) {
      synchronized (ExampleGrpcGrpc.class) {
        if ((getGetListMessageMethod = ExampleGrpcGrpc.getGetListMessageMethod) == null) {
          ExampleGrpcGrpc.getGetListMessageMethod = getGetListMessageMethod = 
              io.grpc.MethodDescriptor.<com.grpc.demo.proto.hellostream.HelloRequest, com.grpc.demo.proto.hellostream.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "hellostream.ExampleGrpc", "getListMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.demo.proto.hellostream.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.demo.proto.hellostream.StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ExampleGrpcMethodDescriptorSupplier("getListMessage"))
                  .build();
          }
        }
     }
     return getGetListMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.HelloRequest,
      com.grpc.demo.proto.hellostream.StudentResponseList> getGetStudentListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudentList",
      requestType = com.grpc.demo.proto.hellostream.HelloRequest.class,
      responseType = com.grpc.demo.proto.hellostream.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.HelloRequest,
      com.grpc.demo.proto.hellostream.StudentResponseList> getGetStudentListMethod() {
    io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.HelloRequest, com.grpc.demo.proto.hellostream.StudentResponseList> getGetStudentListMethod;
    if ((getGetStudentListMethod = ExampleGrpcGrpc.getGetStudentListMethod) == null) {
      synchronized (ExampleGrpcGrpc.class) {
        if ((getGetStudentListMethod = ExampleGrpcGrpc.getGetStudentListMethod) == null) {
          ExampleGrpcGrpc.getGetStudentListMethod = getGetStudentListMethod = 
              io.grpc.MethodDescriptor.<com.grpc.demo.proto.hellostream.HelloRequest, com.grpc.demo.proto.hellostream.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "hellostream.ExampleGrpc", "getStudentList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.demo.proto.hellostream.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.demo.proto.hellostream.StudentResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new ExampleGrpcMethodDescriptorSupplier("getStudentList"))
                  .build();
          }
        }
     }
     return getGetStudentListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.StreamRequest,
      com.grpc.demo.proto.hellostream.StreamResponse> getBiTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiTalk",
      requestType = com.grpc.demo.proto.hellostream.StreamRequest.class,
      responseType = com.grpc.demo.proto.hellostream.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.StreamRequest,
      com.grpc.demo.proto.hellostream.StreamResponse> getBiTalkMethod() {
    io.grpc.MethodDescriptor<com.grpc.demo.proto.hellostream.StreamRequest, com.grpc.demo.proto.hellostream.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = ExampleGrpcGrpc.getBiTalkMethod) == null) {
      synchronized (ExampleGrpcGrpc.class) {
        if ((getBiTalkMethod = ExampleGrpcGrpc.getBiTalkMethod) == null) {
          ExampleGrpcGrpc.getBiTalkMethod = getBiTalkMethod = 
              io.grpc.MethodDescriptor.<com.grpc.demo.proto.hellostream.StreamRequest, com.grpc.demo.proto.hellostream.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "hellostream.ExampleGrpc", "BiTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.demo.proto.hellostream.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.grpc.demo.proto.hellostream.StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ExampleGrpcMethodDescriptorSupplier("BiTalk"))
                  .build();
          }
        }
     }
     return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExampleGrpcStub newStub(io.grpc.Channel channel) {
    return new ExampleGrpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExampleGrpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ExampleGrpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExampleGrpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ExampleGrpcFutureStub(channel);
  }

  /**
   */
  public static abstract class ExampleGrpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void getListMessage(com.grpc.demo.proto.hellostream.HelloRequest request,
        io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMessageMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.HelloRequest> getStudentList(
        io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentListMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetListMessageMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.grpc.demo.proto.hellostream.HelloRequest,
                com.grpc.demo.proto.hellostream.StudentResponse>(
                  this, METHODID_GET_LIST_MESSAGE)))
          .addMethod(
            getGetStudentListMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.grpc.demo.proto.hellostream.HelloRequest,
                com.grpc.demo.proto.hellostream.StudentResponseList>(
                  this, METHODID_GET_STUDENT_LIST)))
          .addMethod(
            getBiTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.grpc.demo.proto.hellostream.StreamRequest,
                com.grpc.demo.proto.hellostream.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class ExampleGrpcStub extends io.grpc.stub.AbstractStub<ExampleGrpcStub> {
    private ExampleGrpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleGrpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleGrpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleGrpcStub(channel, callOptions);
    }

    /**
     */
    public void getListMessage(com.grpc.demo.proto.hellostream.HelloRequest request,
        io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetListMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.HelloRequest> getStudentList(
        io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentListMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ExampleGrpcBlockingStub extends io.grpc.stub.AbstractStub<ExampleGrpcBlockingStub> {
    private ExampleGrpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleGrpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleGrpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleGrpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.grpc.demo.proto.hellostream.StudentResponse> getListMessage(
        com.grpc.demo.proto.hellostream.HelloRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetListMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ExampleGrpcFutureStub extends io.grpc.stub.AbstractStub<ExampleGrpcFutureStub> {
    private ExampleGrpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleGrpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleGrpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleGrpcFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_LIST_MESSAGE = 0;
  private static final int METHODID_GET_STUDENT_LIST = 1;
  private static final int METHODID_BI_TALK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExampleGrpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExampleGrpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LIST_MESSAGE:
          serviceImpl.getListMessage((com.grpc.demo.proto.hellostream.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_LIST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentList(
              (io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StudentResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<com.grpc.demo.proto.hellostream.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ExampleGrpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExampleGrpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.grpc.demo.proto.hellostream.HelloStreamProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExampleGrpc");
    }
  }

  private static final class ExampleGrpcFileDescriptorSupplier
      extends ExampleGrpcBaseDescriptorSupplier {
    ExampleGrpcFileDescriptorSupplier() {}
  }

  private static final class ExampleGrpcMethodDescriptorSupplier
      extends ExampleGrpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExampleGrpcMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExampleGrpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExampleGrpcFileDescriptorSupplier())
              .addMethod(getGetListMessageMethod())
              .addMethod(getGetStudentListMethod())
              .addMethod(getBiTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
