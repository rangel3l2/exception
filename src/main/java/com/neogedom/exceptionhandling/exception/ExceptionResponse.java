package com.neogedom.exceptionhandling.exception;

import java.util.Date;

import lombok.Data;
@Data
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
    private String statusCode;

    public ExceptionResponse(Date timestamp, String message, String details, String statusCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.statusCode = statusCode;
    }

    
}
