package com.beautix.backend.common.exceptions;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Custom exception body.
 *
 * @author David Sapozhnik
 */
@Getter
public class CustomExceptionBody {

    private final String message;
    private final String code;
    private final Map<String, Object> additionalData = new HashMap<>();

    public CustomExceptionBody(ExceptionMessage exceptionMessage) {
        this.message = exceptionMessage.getMessage();
        this.code = exceptionMessage.getCode();
    }

    public CustomExceptionBody(ExceptionMessage exceptionMessage, Map<String, Object> additionalData) {
        this.message = exceptionMessage.getMessage();
        this.code = exceptionMessage.getCode();
        this.additionalData.putAll(additionalData);
    }

    public CustomExceptionBody(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public CustomExceptionBody(String message, String code, Map<String, Object> additionalData) {
        this.message = message;
        this.code = code;
        this.additionalData.putAll(additionalData);
    }
}
