package com.PocketIdentityDirectory.exceptions.ExceptionHandler;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class
    )
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex){

        List<String> errors = new ArrayList<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.add(error.getDefaultMessage())
                );


        return new ResponseEntity<>(new ErrorResponse(400, errors.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignExceptions(FeignException ex){
        return new ResponseEntity<>(new ErrorResponse(ex.status(), ex.getMessage().substring(ex.getMessage().lastIndexOf("\":") + 3, ex.getMessage().length() - 3)), HttpStatusCode.valueOf(ex.status()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleEverythingElse(Exception ex){
        return new ResponseEntity<>(new ErrorResponse(500, "Hi, this is an exception I haven't thought of. That was unexpected :("), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
