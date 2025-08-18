package com.learnnbuildnlearn.auth_service.exception;

import com.learnnbuildnlearn.auth_service.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(UserNotFoundException ex) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(ex.getMessage());

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
