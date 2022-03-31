package org.acme.resource.base;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author leandrosoares
 */
@AllArgsConstructor(staticName = "error")
@Getter
public class RestErrorMessage {
    private String code;
    private String message;
}
