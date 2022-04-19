package com.example.service;

import com.example.add.AddRequest;
import com.example.add.AddResponse;
import com.example.add.AddServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AddServiceGrpcImpl extends AddServiceGrpc.AddServiceImplBase{

    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
        System.out.println("Add request for "+request.getA()+">>"+request.getB());
        responseObserver.onNext(AddResponse.newBuilder().setResult(request.getA()+request.getB()).build());
        responseObserver.onCompleted();
    }
}
