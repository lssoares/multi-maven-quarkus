package org.acme.test.repository;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.repository.example.ExampleEntity;
import org.acme.repository.example.ExampleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * @author leandrosoares
 */
@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class ExampleRepositoryTest {

    @Inject
    ExampleRepository exampleRepository;

    private void createOneRow() {
        ExampleEntity e = new ExampleEntity();
        e.setCode("TEST");
        exampleRepository.persist(e);
    }


    @Test
    @Transactional
    public void getList() {
        createOneRow();

        List<ExampleEntity> list = exampleRepository.listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() == 1);
    }

}
