package org.acme.example;

import org.acme.base.RestErrorMessage;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.models.examples.Example;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.eclipse.microprofile.openapi.annotations.enums.SchemaType.ARRAY;
import static org.eclipse.microprofile.openapi.annotations.enums.SchemaType.OBJECT;

/**
 * @author jorgepereira
 */

@Path("/examples")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public interface ExampleApi {

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
    Response list();

    @GET
    @Path("testAnnotations")
    @Operation(
            operationId = "GetExamples",
            summary = "List all Examples"
    )
    @Timeout(1000)
    @CircuitBreaker(requestVolumeThreshold = 5, failureRatio = 1, delay = 60000)
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
    Response testWs();
}
