package com.knf.dev.demo.response;

public class ErrorMessage {

    private int status;
    private String error;

    private String description;

    public ErrorMessage() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ErrorMessage(int status, String error, String description) {
        this.status = status;
        this.error = error;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}