package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlePlantException(PlantException plantException){
        ErrorResponse plantErrorResponse = new ErrorResponse(plantException.getMessage());
        return new ResponseEntity<>(plantErrorResponse, plantException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlePlantException(Exception exception){
        ErrorResponse plantErrorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(plantErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
