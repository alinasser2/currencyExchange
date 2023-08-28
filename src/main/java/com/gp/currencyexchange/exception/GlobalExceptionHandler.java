package com.gp.currencyexchange.exception;

import com.gp.currencyexchange.exception.customize.CustomException;
import com.gp.currencyexchange.web.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpClientErrorException(HttpClientErrorException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode().value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpServerErrorException(HttpServerErrorException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode().value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }


    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ErrorResponse> handleNumberFormatException(NumberFormatException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid number format");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

