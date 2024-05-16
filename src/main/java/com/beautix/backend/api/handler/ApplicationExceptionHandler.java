package com.beautix.backend.api.handler;

import com.beautix.backend.common.exceptions.CustomException;
import com.beautix.backend.common.exceptions.CustomExceptionBody;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.beautix.backend.common.exceptions.ExceptionMessage.INTERNAL_SERVER_ERROR;

/**
 * Exception handler
 *
 * @author David Sapozhnik
 */
@Log4j2
@ControllerAdvice(basePackages = "com.beautix.backend.api.controller")
public class ApplicationExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionBody> handleCustomException(CustomException e) {
        log.warn("Custom exception occurred: {}", e.getMessage());
        return ResponseEntity.status(e.getStatusCode()).body(e.getBody());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CustomExceptionBody> handleRuntimeException(RuntimeException e) {
        log.error("Runtime exception occurred: {}", e.getMessage(), e);
        var error = INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(error.getStatusCode()).body(new CustomExceptionBody(error));
    }

    //TODO: Add more exception handlers
}
