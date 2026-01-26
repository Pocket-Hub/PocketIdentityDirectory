package com.PocketIdentityDirectory.exceptions.ExceptionHandler;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class
    )
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex) {

        List<String> errors = new ArrayList<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.add(error.getDefaultMessage())
                );

        return new ResponseEntity<>(new ErrorResponse(400, errors.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignExceptions(FeignException ex) {
        int status = ex.status();

        if (status < 100 || status > 599) {
            status = 503;
        }

        return new ResponseEntity<>(new ErrorResponse(status, "There was an issue with the API Request. " + ex.getMessage().substring(ex.getMessage().lastIndexOf("\":") + 3, ex.getMessage().length() - 3)), HttpStatusCode.valueOf(status));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleEverythingElse(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(500, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
