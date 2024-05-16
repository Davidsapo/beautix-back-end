package com.beautix.backend.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;


/**
 * Exception messages
 *
 * @author David Sapozhnik
 */
@Getter
@AllArgsConstructor
public enum ExceptionMessage {

    INTERNAL_SERVER_ERROR("Internal server error", "INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
    UNAUTHORIZED("Access denied", "UNAUTHORIZED", HttpStatus.UNAUTHORIZED),
    FORBIDDEN("Forbidden", "FORBIDDEN", HttpStatus.FORBIDDEN),
    USER_NOT_FOUND("User not found", "USER_NOT_FOUND", HttpStatus.NOT_FOUND),
    SESSION_NOT_FOUND("Session not found", "SESSION_NOT_FOUND", HttpStatus.NOT_FOUND);

    private final String message;
    private final String code;
    private final HttpStatus statusCode;

    public void throwException() throws CustomException {
        throw new CustomException(this);
    }

    public void throwException(Map<String, Object> additionalData) throws CustomException {
        throw new CustomException(this, additionalData);
    }

    public CustomException getException() {
        return new CustomException(this);
    }

    public CustomException getException(Map<String, Object> additionalData) {
        return new CustomException(this, additionalData);
    }
}
