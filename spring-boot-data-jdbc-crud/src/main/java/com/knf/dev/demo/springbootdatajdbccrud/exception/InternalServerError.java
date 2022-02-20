package com.knf.dev.demo.springbootdatajdbccrud.exception;
public class InternalServerError extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InternalServerError(String msg) {
        super(msg);
    }
}