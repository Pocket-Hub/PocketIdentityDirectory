package com.PocketIdentityDirectory.exceptions.ExceptionHandler;

import com.PocketIdentityDirectory.exceptions.EntityNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(404, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleException(HttpMessageNotReadableException ex) {
        log.error("Could not deserialize JSON", ex);
        return new ResponseEntity<>(new ErrorResponse(400, "Could not deserialize JSON"), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class
    )
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex) {

        List<String> errors = new ArrayList<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.add(error.getDefaultMessage())
                );
        log.error("Validation Exception", ex);
        return new ResponseEntity<>(new ErrorResponse(400, errors.size() == 1 ? errors.get(0) : errors.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FeignException.Conflict.class)
    public ResponseEntity<ErrorResponse> handleConflictException(FeignException ex) {
        ErrorResponse res = new ErrorResponse();
        res.setStatus(ex.status());

        if (ex.getMessage().contains("email")) {
            res.setMessage("A user with the same primary email already exists!");
        } else if (ex.getMessage().contains(" name ")) {
            res.setMessage("A group with the same name already exists!");
        } else if (ex.getMessage().contains("User with same unique attribute already exists")) {
            res.setMessage("A user with the same username already exists!");
        } else {
            res.setMessage(ex.getMessage());
        }

        log.error("Conflict in unique attribute", ex);

        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignExceptions(FeignException ex) throws JsonProcessingException {

        Optional<ByteBuffer> body = ex.responseBody();
        String str = "";
        if (body.isPresent()) {
            str = new String(body.get().array(), StandardCharsets.UTF_8);
        }

        IASErrorResponse errorRes = objectMapper.readValue(str, IASErrorResponse.class);

        int status = errorRes.getStatus();
        ErrorResponse res = new ErrorResponse();
        res.setMessage(errorRes.getDetail());
        res.setStatus(status);

        System.out.println(str);

        log.error("Exception in API call to IAS", ex);

        return new ResponseEntity<>(res, HttpStatusCode.valueOf(status));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleEverythingElse(Exception ex) {
        log.error("Unexpected Exception", ex);
        return new ResponseEntity<>(new ErrorResponse(500, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
