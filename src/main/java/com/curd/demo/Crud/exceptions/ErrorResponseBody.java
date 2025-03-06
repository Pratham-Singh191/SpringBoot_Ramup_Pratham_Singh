package com.curd.demo.Crud.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Setter
@Getter
public class ErrorResponseBody {
    private HttpStatus status;
    private String message;
    private StackTraceElement[] stackTrace;

    public ErrorResponseBody(Exception exception, HttpStatus status) {
        this.status = status;
        this.message = exception.getMessage();
        this.stackTrace = exception.getStackTrace();

    }
}
