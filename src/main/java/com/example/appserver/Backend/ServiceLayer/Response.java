package com.example.appserver.Backend.ServiceLayer;

public class Response<T> {

    private boolean isError;
    private String errorMessage;
    private T returnValue;

    // Constructor for error responses
    public Response(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
        this.returnValue = null;
    }

    // Constructor for successful responses
    public Response(T returnValue) {
        this.isError = false;
        this.returnValue = returnValue;
        this.errorMessage = null;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(T returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public String toString() {
        return "Response{" +
                "isError=" + isError +
                ", errorMessage='" + errorMessage + '\'' +
                ", returnValue=" + returnValue +
                '}';
    }
}
