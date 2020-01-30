package org.acme.resource.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;

/**
 * @author leandrosoares
 */
@QuarkusTest
public class ExampleResourceTest {

    //@Test
    public void getList() {

        given()
                .when()
                .get("/examples")
                .then()
                .statusCode(200);
    }


    //@Test
    void testAnnotationOnInterface() {

        given()
                .when()
                .get("/examples/testAnnotationOnInterface")
                .then()
                .statusCode(Response.Status.REQUEST_TIMEOUT.getStatusCode());

    }


    //@Test
    void testAnnotationOnImplementation() {

        given()
                .when()
                .get("/examples/testAnnotationOnImplementation")
                .then()
                .statusCode(Response.Status.REQUEST_TIMEOUT.getStatusCode());

    }

}
