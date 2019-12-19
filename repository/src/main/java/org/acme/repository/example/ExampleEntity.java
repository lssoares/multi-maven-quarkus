package org.acme.repository.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author leandrosoares
 */
@Entity
@Table(name = "example")
public class ExampleEntity extends PanacheEntity {

    public String code;
}
