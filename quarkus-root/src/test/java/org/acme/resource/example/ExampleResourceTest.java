package org.acme.resource.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

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



}
