package org.acme.service.example;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author leandrosoares
 */

@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Data
public class Example {

    private Long id;
    private String code;
}
