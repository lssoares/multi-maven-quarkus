package org.acme.resource.example;

import org.acme.example.ExampleApi;
import org.acme.service.example.ExampleService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;


public class ExampleResource implements ExampleApi {

    @Inject
    ExampleService exampleService;

    @Override
    public Response list() {

        return Response.ok(exampleService.listAll()).build();
    }

    @Override
    public Response testWs(){
        return Response.ok(exampleService.annotationsTest()).build();
    }

}