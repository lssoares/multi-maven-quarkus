package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @author leandrosoares
 */
@QuarkusTest
public class ExampleResourceTest {

    /*
    @Inject
    ExampleResourceWrapper exampleResource;

    @Test
    public void getList() {

        List<ExampleEntity> list = exampleResource.listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() > 0);

    }



    // Workaround to fix https://github.com/quarkusio/quarkus/issues/1724.
    @ApplicationScoped
    @Transactional
    static class ExampleResourceWrapper {
        @Inject
        @Delegate
        ExampleResource exampleResource;

    }
    */


    @Test
    public void getList() {

        given().port(8081)
                .when()
                .get("/examples")
                .then()
                .statusCode(200);
    }



}
