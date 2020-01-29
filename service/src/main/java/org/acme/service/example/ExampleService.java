package org.acme.service.example;

import org.acme.repository.example.ExampleRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
        try {
            Thread.sleep(3000);
            return "I waited long enough";
        } catch (InterruptedException e) {
            return "Exception caught";
        }
    }
}
