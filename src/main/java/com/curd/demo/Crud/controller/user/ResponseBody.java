package com.curd.demo.Crud.controller.user;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseBody<T> {
    private HttpStatus status;
    private String message;
    private T data;

    public ResponseBody(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
