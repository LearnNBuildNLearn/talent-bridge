package com.learnnbuildnlearn.job_service.Exception;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException(String message){
        super(message);
    }
}
