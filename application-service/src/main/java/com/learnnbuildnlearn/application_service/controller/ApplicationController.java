package com.learnnbuildnlearn.application_service.controller;

import com.learnnbuildnlearn.application_service.dto.ApplicationResponse;
import com.learnnbuildnlearn.application_service.model.Status;
import com.learnnbuildnlearn.application_service.service.ApplicationService;
import com.learnnbuildnlearn.application_service.exception.InvalidRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping(path = "/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(path = "/track/{id}")
    private ResponseEntity<ApplicationResponse> trackApplication(@PathVariable String id) {
        UUID applicationId;
        try {
            applicationId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("invalid UUID format");
        }

        return ResponseEntity.ok(applicationService.trackApplication(applicationId));
    }

    @PostMapping(path = "/apply/{id}")
    private ResponseEntity<ApplicationResponse> applyJob(@PathVariable String id) {
        UUID jobId;
        try {
            jobId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("invalid UUID format");
        }

        return ResponseEntity.ok(applicationService.applyJob(jobId));
    }

    @PatchMapping(path = "/update-status")
    private ResponseEntity<ApplicationResponse> updateStatus(@RequestParam String id, @RequestParam String status) {
        UUID applicationId;
        Status newStatus;

        // Validate UUID
        try {
            applicationId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("invalid UUID format");
        }

        // Validate Status
        try {
            newStatus = Status.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidRequestException("invalid status value: " + status +
                    ". Allowed values: " + Arrays.toString(Status.values()));
        }

        return ResponseEntity.ok(applicationService.updateStatus(applicationId, newStatus));
    }
}
