package org.acme.test.service;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.service.example.Example;
import org.acme.service.example.ExampleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

/**
 * @author leandrosoares
 */
@QuarkusTest
public class ExampleServiceTest {

    @Inject
    ExampleService exampleService;

    @Test
    public void getList() {
        List<Example> list = exampleService.listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() == 1);
    }



}
