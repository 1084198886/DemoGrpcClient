package com.grpc.godemo;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.1)",
    comments = "Source: app.proto")
public final class AppSignDeviceGrpcx {

  private AppSignDeviceGrpcx() {}

  public static final String SERVICE_NAME = "AppSignDevice";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GoGrpcUtilx.AppSign,
      GoGrpcUtilx.AppSignResponse> getSigninMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Signin",
      requestType = GoGrpcUtilx.AppSign.class,
      responseType = GoGrpcUtilx.AppSignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GoGrpcUtilx.AppSign,
      GoGrpcUtilx.AppSignResponse> getSigninMethod() {
    io.grpc.MethodDescriptor<GoGrpcUtilx.AppSign, GoGrpcUtilx.AppSignResponse> getSigninMethod;
    if ((getSigninMethod = AppSignDeviceGrpcx.getSigninMethod) == null) {
      synchronized (AppSignDeviceGrpcx.class) {
        if ((getSigninMethod = AppSignDeviceGrpcx.getSigninMethod) == null) {
          AppSignDeviceGrpcx.getSigninMethod = getSigninMethod =
              io.grpc.MethodDescriptor.<GoGrpcUtilx.AppSign, GoGrpcUtilx.AppSignResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Signin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  GoGrpcUtilx.AppSign.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  GoGrpcUtilx.AppSignResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getSigninMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AppSignDeviceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppSignDeviceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppSignDeviceStub>() {
        @Override
        public AppSignDeviceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppSignDeviceStub(channel, callOptions);
        }
      };
    return AppSignDeviceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppSignDeviceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppSignDeviceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppSignDeviceBlockingStub>() {
        @Override
        public AppSignDeviceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppSignDeviceBlockingStub(channel, callOptions);
        }
      };
    return AppSignDeviceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AppSignDeviceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppSignDeviceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppSignDeviceFutureStub>() {
        @Override
        public AppSignDeviceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppSignDeviceFutureStub(channel, callOptions);
        }
      };
    return AppSignDeviceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AppSignDeviceImplBase implements io.grpc.BindableService {

    /**
     */
    public void signin(GoGrpcUtilx.AppSign request,
                       io.grpc.stub.StreamObserver<GoGrpcUtilx.AppSignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSigninMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSigninMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                GoGrpcUtilx.AppSign,
                GoGrpcUtilx.AppSignResponse>(
                  this, METHODID_SIGNIN)))
          .build();
    }
  }

  /**
   */
  public static final class AppSignDeviceStub extends io.grpc.stub.AbstractAsyncStub<AppSignDeviceStub> {
    private AppSignDeviceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AppSignDeviceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppSignDeviceStub(channel, callOptions);
    }

    /**
     */
    public void signin(GoGrpcUtilx.AppSign request,
                       io.grpc.stub.StreamObserver<GoGrpcUtilx.AppSignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSigninMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AppSignDeviceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AppSignDeviceBlockingStub> {
    private AppSignDeviceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AppSignDeviceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppSignDeviceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GoGrpcUtilx.AppSignResponse signin(GoGrpcUtilx.AppSign request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSigninMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AppSignDeviceFutureStub extends io.grpc.stub.AbstractFutureStub<AppSignDeviceFutureStub> {
    private AppSignDeviceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected AppSignDeviceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppSignDeviceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GoGrpcUtilx.AppSignResponse> signin(
        GoGrpcUtilx.AppSign request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSigninMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIGNIN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AppSignDeviceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AppSignDeviceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIGNIN:
          serviceImpl.signin((GoGrpcUtilx.AppSign) request,
              (io.grpc.stub.StreamObserver<GoGrpcUtilx.AppSignResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AppSignDeviceGrpcx.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getSigninMethod())
              .build();
        }
      }
    }
    return result;
  }
}
