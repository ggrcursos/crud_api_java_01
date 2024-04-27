package com.crud.ApiCrud.controller;

import com.crud.ApiCrud.observability.SimpleLogger;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandlerController {
    private final ErrorAttributes errorAttributes = new DefaultErrorAttributes();
    SimpleLogger logger = new SimpleLogger(ErrorHandlerController.class);
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Map<String, Object>> handleException(Exception ex, WebRequest request) {
        logger.error(ex.toString());
        String errorMessage = "Cannot GET /";
        String error = "Not Found";
        int statusCode = HttpStatus.NOT_FOUND.value();

        // Create your custom error response structure
        Map<String, Object> customErrorResponse = new HashMap<>();
        customErrorResponse.put("message", errorMessage);
        customErrorResponse.put("error", error);
        customErrorResponse.put("statusCode", statusCode);

        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }
}