package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

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


    //@Test
    public void getList() {

        given().port(8081)
                .when()
                .get("/examples")
                .then()
                .statusCode(200);
    }



}
