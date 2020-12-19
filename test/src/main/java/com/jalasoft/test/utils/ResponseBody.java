package com.jalasoft.test.utils;

public class ResponseBody<T> {

    private T body;
    private String message;
    private String status;

    public ResponseBody(T body, String message, String status) {
        this.body = body;
        this.message = message;
        this.status = status;
    }

    public ResponseBody(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
