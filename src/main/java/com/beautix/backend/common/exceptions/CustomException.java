package com.beautix.backend.common.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.util.Map;

/**
 * Custom exception.
 *
 * @author David Sapozhnik
 */
@Getter
public class CustomException extends Exception {

    private final HttpStatusCode statusCode;
    private final CustomExceptionBody body;

    public CustomException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.body = new CustomExceptionBody(exceptionMessage);
        this.statusCode = exceptionMessage.getStatusCode();
    }

    public CustomException(ExceptionMessage exceptionMessage, Map<String, Object> additionalData) {
        super(exceptionMessage.getMessage());
        this.statusCode = exceptionMessage.getStatusCode();
        this.body = new CustomExceptionBody(exceptionMessage, additionalData);
    }

    public CustomException(String message, String code, HttpStatusCode statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.body = new CustomExceptionBody(message, code);
    }

    public CustomException(String message, String code, HttpStatusCode statusCode, Map<String, Object> additionalData) {
        super(message);
        this.statusCode = statusCode;
        this.body = new CustomExceptionBody(message, code, additionalData);
    }
}
