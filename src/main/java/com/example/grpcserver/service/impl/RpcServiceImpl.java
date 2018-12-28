package com.example.grpcserver.service.impl;

import com.example.grpcserver.domain.User;
import com.example.grpcserver.service.Server;
import com.example.grpcserver.service.UserRpcServiceGrpc;
import com.example.grpcserver.service.UserService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class RpcServiceImpl extends UserRpcServiceGrpc.UserRpcServiceImplBase {
    private final UserService userService;

    @Autowired
    RpcServiceImpl(UserService userService){
        this.userService=userService;
    }

    @Override
    public void getUserById(Server.TestRequest request, StreamObserver<Server.TestResponse> responseStreamObserver){
        Server.TestResponse.Builder builder= Server.TestResponse.newBuilder();
        try {
            User user =userService.getUserById((int)request.getId());
            builder.setId(user.getId());
            builder.setUsername(user.getUsername());
            builder.setAge(user.getAge());
        }catch (Exception e){
            builder.setId(0);
            builder.setUsername("Null");
            builder.setAge(999);
        }
        Server.TestResponse response=builder.build();
        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();

    }
}
