package org.acme.resource.exception;

import org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author leandrosoares
 */

@Provider
public class TimeoutExceptionHandler implements ExceptionMapper<TimeoutException> {

    private final Logger logger = LoggerFactory.getLogger(UnhandledExceptionHandler.class);

    @Override
    public Response toResponse(TimeoutException exception) {
        exception.printStackTrace();

        return Response.status(Response.Status.REQUEST_TIMEOUT)
                .entity(JsonbBuilder.create().toJson(Response.Status.REQUEST_TIMEOUT.getReasonPhrase()))
                .build();

    }
}
