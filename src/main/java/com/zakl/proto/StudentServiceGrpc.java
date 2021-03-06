package com.zakl.proto;

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
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: Srudent.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.zakl.protobuf.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<MyRequest,
      MyResponse> getGetRealNameByUserNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUserName",
      requestType = MyRequest.class,
      responseType = MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MyRequest,
      MyResponse> getGetRealNameByUserNameMethod() {
    io.grpc.MethodDescriptor<MyRequest, MyResponse> getGetRealNameByUserNameMethod;
    if ((getGetRealNameByUserNameMethod = StudentServiceGrpc.getGetRealNameByUserNameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealNameByUserNameMethod = StudentServiceGrpc.getGetRealNameByUserNameMethod) == null) {
          StudentServiceGrpc.getGetRealNameByUserNameMethod = getGetRealNameByUserNameMethod = 
              io.grpc.MethodDescriptor.<MyRequest, MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.zakl.protobuf.StudentService", "GetRealNameByUserName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetRealNameByUserName"))
                  .build();
          }
        }
     }
     return getGetRealNameByUserNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentRequest,
      StudentResponse> getGetStudentsBuAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsBuAge",
      requestType = StudentRequest.class,
      responseType = StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<StudentRequest,
      StudentResponse> getGetStudentsBuAgeMethod() {
    io.grpc.MethodDescriptor<StudentRequest, StudentResponse> getGetStudentsBuAgeMethod;
    if ((getGetStudentsBuAgeMethod = StudentServiceGrpc.getGetStudentsBuAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentsBuAgeMethod = StudentServiceGrpc.getGetStudentsBuAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentsBuAgeMethod = getGetStudentsBuAgeMethod = 
              io.grpc.MethodDescriptor.<StudentRequest, StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.zakl.protobuf.StudentService", "GetStudentsBuAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentsBuAge"))
                  .build();
          }
        }
     }
     return getGetStudentsBuAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentRequest,
      StudentResponseList> getGetStudentWrapperByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentWrapperByAges",
      requestType = StudentRequest.class,
      responseType = StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<StudentRequest,
      StudentResponseList> getGetStudentWrapperByAgesMethod() {
    io.grpc.MethodDescriptor<StudentRequest, StudentResponseList> getGetStudentWrapperByAgesMethod;
    if ((getGetStudentWrapperByAgesMethod = StudentServiceGrpc.getGetStudentWrapperByAgesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentWrapperByAgesMethod = StudentServiceGrpc.getGetStudentWrapperByAgesMethod) == null) {
          StudentServiceGrpc.getGetStudentWrapperByAgesMethod = getGetStudentWrapperByAgesMethod = 
              io.grpc.MethodDescriptor.<StudentRequest, StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.zakl.protobuf.StudentService", "GetStudentWrapperByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentWrapperByAges"))
                  .build();
          }
        }
     }
     return getGetStudentWrapperByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentRequest,
      StudentResponse> getGetStudentWrapperByAges2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentWrapperByAges2",
      requestType = StudentRequest.class,
      responseType = StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<StudentRequest,
      StudentResponse> getGetStudentWrapperByAges2Method() {
    io.grpc.MethodDescriptor<StudentRequest, StudentResponse> getGetStudentWrapperByAges2Method;
    if ((getGetStudentWrapperByAges2Method = StudentServiceGrpc.getGetStudentWrapperByAges2Method) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentWrapperByAges2Method = StudentServiceGrpc.getGetStudentWrapperByAges2Method) == null) {
          StudentServiceGrpc.getGetStudentWrapperByAges2Method = getGetStudentWrapperByAges2Method = 
              io.grpc.MethodDescriptor.<StudentRequest, StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.zakl.protobuf.StudentService", "GetStudentWrapperByAges2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentWrapperByAges2"))
                  .build();
          }
        }
     }
     return getGetStudentWrapperByAges2Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    return new StudentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUserName(MyRequest request,
                                      io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUserNameMethod(), responseObserver);
    }

    /**
     */
    public void getStudentsBuAge(StudentRequest request,
                                 io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsBuAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentWrapperByAges(
        io.grpc.stub.StreamObserver<StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentWrapperByAgesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentWrapperByAges2(
        io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentWrapperByAges2Method(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUserNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                MyRequest,
                MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USER_NAME)))
          .addMethod(
            getGetStudentsBuAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                StudentRequest,
                StudentResponse>(
                  this, METHODID_GET_STUDENTS_BU_AGE)))
          .addMethod(
            getGetStudentWrapperByAgesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                StudentRequest,
                StudentResponseList>(
                  this, METHODID_GET_STUDENT_WRAPPER_BY_AGES)))
          .addMethod(
            getGetStudentWrapperByAges2Method(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                StudentRequest,
                StudentResponse>(
                  this, METHODID_GET_STUDENT_WRAPPER_BY_AGES2)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractStub<StudentServiceStub> {
    private StudentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUserName(MyRequest request,
                                      io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentsBuAge(StudentRequest request,
                                 io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsBuAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentWrapperByAges(
        io.grpc.stub.StreamObserver<StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentWrapperByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StudentRequest> getStudentWrapperByAges2(
        io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetStudentWrapperByAges2Method(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public MyResponse getRealNameByUserName(MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUserNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<StudentResponse> getStudentsBuAge(
        StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentsBuAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MyResponse> getRealNameByUserName(
        MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USER_NAME = 0;
  private static final int METHODID_GET_STUDENTS_BU_AGE = 1;
  private static final int METHODID_GET_STUDENT_WRAPPER_BY_AGES = 2;
  private static final int METHODID_GET_STUDENT_WRAPPER_BY_AGES2 = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USER_NAME:
          serviceImpl.getRealNameByUserName((MyRequest) request,
              (io.grpc.stub.StreamObserver<MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BU_AGE:
          serviceImpl.getStudentsBuAge((StudentRequest) request,
              (io.grpc.stub.StreamObserver<StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_WRAPPER_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentWrapperByAges(
              (io.grpc.stub.StreamObserver<StudentResponseList>) responseObserver);
        case METHODID_GET_STUDENT_WRAPPER_BY_AGES2:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentWrapperByAges2(
              (io.grpc.stub.StreamObserver<StudentResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return StudentProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUserNameMethod())
              .addMethod(getGetStudentsBuAgeMethod())
              .addMethod(getGetStudentWrapperByAgesMethod())
              .addMethod(getGetStudentWrapperByAges2Method())
              .build();
        }
      }
    }
    return result;
  }
}
