package org.acme.service.example;

import org.acme.repository.example.ExampleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author leandrosoares
 */
@Mapper
public interface ExampleMapper {

    static ExampleMapper getInstance() {
        return Mappers.getMapper(ExampleMapper.class);
    }

    Example toModel(ExampleEntity source);

    ExampleEntity toEntity(Example source);

    @Mapping(target = "id", ignore = true)
    ExampleEntity toEntity(ExampleEntity source, @MappingTarget ExampleEntity target);

}
