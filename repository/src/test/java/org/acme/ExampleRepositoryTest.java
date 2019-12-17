package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

/**
 * @author leandrosoares
 */
@QuarkusTest
public class ExampleRepositoryTest {

    @Inject
    ExampleRepository exampleRepository;

    @Test
    public void getList() {
        List<ExampleEntity> list = exampleRepository.listAll();
        Assertions.assertTrue(Objects.nonNull(list) && list.size() > 0);
    }


}
