package org.acme.repository.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author leandrosoares
 */
@Entity
@Table(name = "example")
@Data
public class ExampleEntity extends PanacheEntity {

    private String code;
}
