package org.acme.resource.example;

import org.acme.example.ExampleApi;
import org.acme.service.example.ExampleService;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Response;


public class ExampleResource implements ExampleApi {

    @Inject
    ExampleService exampleService;

    @Override
    public Response list() {

        return Response.ok(exampleService.listAll()).build();
    }

    @Override
    public Response testAnnotationOnInterfaceWs(){
        return Response.ok(JsonbBuilder.create().toJson(exampleService.annotationsTest())).build();
    }

    @Override
    @Timeout(1000)
    @CircuitBreaker(requestVolumeThreshold = 2, failureRatio = 0.5, delay = 10000, successThreshold = 1)
    public Response testAnnotationOnImplementationWs(){
        return Response.ok(JsonbBuilder.create().toJson(exampleService.annotationsTest())).build();
    }

}