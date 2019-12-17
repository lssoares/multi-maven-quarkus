package org.acme;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.eclipse.microprofile.openapi.annotations.enums.SchemaType.ARRAY;
import static org.eclipse.microprofile.openapi.annotations.enums.SchemaType.OBJECT;


@Path("/examples")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class ExampleResource {

    @Inject
    ExampleService exampleService;

    @GET
    @Path("")
    @Operation(
            operationId = "GetExamples",
            summary = "List all Examples"
    )

    @APIResponse(responseCode = "200",
            content = @Content(mediaType = APPLICATION_JSON,
                    schema = @Schema(type = ARRAY,
                            implementation = Example.class)))
    @APIResponse(responseCode = "404",
            content = @Content(mediaType = APPLICATION_JSON,
                    schema = @Schema(type = OBJECT,
                            implementation = RestErrorMessage.class)))
    @APIResponse(responseCode = "500",
            content = @Content(mediaType = APPLICATION_JSON,
                    schema = @Schema(type = OBJECT,
                            implementation = RestErrorMessage.class)))
    public Response list() {

        return Response.ok(exampleService.listAll()).build();
    }

}