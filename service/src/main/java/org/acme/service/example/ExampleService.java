package org.acme.service.example;

import org.acme.repository.example.ExampleRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.rmi.UnexpectedException;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author leandrosoares
 */
@ApplicationScoped
public class ExampleService {

    @Inject
    ExampleRepository exampleRepository;


    public List<Example> listAll() {
        return exampleRepository.findAll()
                .stream()
                .map(ExampleMapper.getInstance()::toModel)
                .collect(toList());
    }

    public String annotationsTest() {
        int waitTimeInMilis = 3000;
        try {
            Thread.sleep(waitTimeInMilis);
            StringBuilder sb = new StringBuilder()
                    .append("I waited for ")
                    .append(waitTimeInMilis)
                    .append(" miliseconds at least....Timeout shouuld happen after 1 second.")
                    .append(" I hope next time, circuit breaker will act!");

            throw new RuntimeException(sb.toString());
        } catch (InterruptedException e) {
            return e.getMessage();
        }
    }
}
