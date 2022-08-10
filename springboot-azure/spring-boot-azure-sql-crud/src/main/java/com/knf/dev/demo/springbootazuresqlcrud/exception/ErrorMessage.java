package com.knf.dev.demo.springbootazuresqlcrud.exception;
import java.util.Date;

public class ErrorMessage {

    private Integer statusCode;
    private Date timestamp;
    private String message;
    private String description;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ErrorMessage(Integer statusCode,
         Date timestamp, String message, 
             String description) {
        super();
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}