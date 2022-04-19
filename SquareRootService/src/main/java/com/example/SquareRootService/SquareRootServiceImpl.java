package com.example.SquareRootService;

import com.example.squareRoot.SquareRootRequest;
import com.example.squareRoot.SquareRootResponse;
import com.example.squareRoot.SquareRootServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SquareRootServiceImpl extends SquareRootServiceGrpc.SquareRootServiceImplBase {
    @Override
    public void squareRoot(SquareRootRequest request, StreamObserver<SquareRootResponse> responseObserver) {
        System.out.println("finding square root for the given number>>"+request.getNumber());
        responseObserver.onNext(SquareRootResponse.newBuilder().setRoot(Math.sqrt(request.getNumber())).build());
        responseObserver.onCompleted();
    }
}