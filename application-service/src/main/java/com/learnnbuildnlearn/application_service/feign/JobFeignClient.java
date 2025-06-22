package com.learnnbuildnlearn.application_service.feign;

import com.learnnbuildnlearn.application_service.feign.model.JobResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "job-service", url = "http://localhost:8082")
public interface JobFeignClient {
    @GetMapping("/job/{jobId}")
    JobResponse getJobById(@PathVariable("jobId") UUID jobId);
}
