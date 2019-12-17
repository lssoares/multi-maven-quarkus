/*
 * Prozis Tech Copyright (c) 2019.
 */

package org.acme;


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