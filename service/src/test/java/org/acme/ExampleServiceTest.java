package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import java.util.List;
import java.util.Objects;

/**
 * @author leandrosoares
 */
@QuarkusTest
public class ExampleServiceTest {

    /*
    @Inject
    ExampleServiceWrapper exampleService;

    @Test
    public void getList() {

        List<ExampleEntity> list = exampleService.listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() > 0);

    }



    // Workaround to fix https://github.com/quarkusio/quarkus/issues/1724.
    @ApplicationScoped
    @Transactional
    static class ExampleServiceWrapper {
        @Inject
        @Delegate
        ExampleService exampleService;

    }
    */


    @Test
    public void getList() {

        Instance<ExampleService> exampleServiceInstance = CDI.current().select(ExampleService.class);
        ExampleService exampleService = exampleServiceInstance.get();

        List<Example> list = exampleService.listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() > 0);


        CDI.current().destroy(exampleServiceInstance);
    }



}
