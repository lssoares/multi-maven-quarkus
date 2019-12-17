package org.acme;

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

}
