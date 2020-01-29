package org.acme.resource.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;

/**
 * @author leandrosoares
 */
@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void getList() {

        given()
                .when()
                .get("/examples")
                .then()
                .statusCode(200);
    }


    @Test
    void testWs() {

        given()
                .when()
                .get("/examples/testAnnotations")
                .then()
                .statusCode(500);

    }
}
