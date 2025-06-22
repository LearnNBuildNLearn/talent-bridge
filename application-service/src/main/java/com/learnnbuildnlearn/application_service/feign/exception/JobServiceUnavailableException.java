package com.learnnbuildnlearn.application_service.feign.exception;

public class JobServiceUnavailableException extends RuntimeException {
    public JobServiceUnavailableException(String message) {
        super(message);
    }
}
