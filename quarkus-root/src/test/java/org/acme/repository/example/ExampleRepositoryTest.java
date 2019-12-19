package org.acme.repository.example;

import io.quarkus.test.junit.QuarkusTest;
import lombok.experimental.Delegate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * @author leandrosoares
 */
@QuarkusTest
public class ExampleRepositoryTest {

    /*
    @Inject
    ExampleRepositoryWrapper exampleRepository;
    @Test
    public void getList() {
        List<ExampleEntity> list = exampleRepository.listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() > 0);
    }
    // Workaround to fix https://github.com/quarkusio/quarkus/issues/1724.
    @ApplicationScoped
    @Transactional
    static class ExampleRepositoryWrapper {
        @Inject
        @Delegate
        ExampleRepository exampleRepository;
    }
    */


    @Test
    public void getList() {

        Instance<ExampleRepository> exampleRepositoryInstance = CDI.current().select(ExampleRepository.class);
        ExampleRepository exampleRepository = exampleRepositoryInstance.get();

        List<ExampleEntity> list = exampleRepository.listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() > 0);


        CDI.current().destroy(exampleRepositoryInstance);
    }



}