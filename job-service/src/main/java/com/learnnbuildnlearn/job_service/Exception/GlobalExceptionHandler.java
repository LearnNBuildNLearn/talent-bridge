package com.learnnbuildnlearn.job_service.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler  {


  public ResponseEntity<Map<String, String>> handleJobNotFoundException(JobNotFoundException ex) {

    Map<String, String> errors = new HashMap<>();
    errors.put("message","Job Not Found");
    return ResponseEntity.badRequest().body(errors);
  }

}
