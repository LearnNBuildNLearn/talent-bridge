package com.learnnbuildnlearn.application_service.feign.exception;

public class JobException extends RuntimeException {
    public JobException(String message) {
        super(message);
    }
}
