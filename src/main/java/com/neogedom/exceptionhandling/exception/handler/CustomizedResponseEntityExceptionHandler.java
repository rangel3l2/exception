package com.neogedom.exceptionhandling.exception.handler;

import com.neogedom.exceptionhandling.exception.ExceptionResponse;
import com.neogedom.exceptionhandling.exception.InvalidCharacterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice // Captura as Exceções
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        var exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidCharacterException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {
        var exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
      @ExceptionHandler(NumberFormatException.class)
      public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions2(Exception ex, WebRequest request) {
          var exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    
     return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
