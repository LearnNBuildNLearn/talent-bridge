package com.learnnbuildnlearn.application_service.service;

import com.learnnbuildnlearn.application_service.dto.ApplicationResponse;
import com.learnnbuildnlearn.application_service.exception.UniqueConstraintViolationException;
import com.learnnbuildnlearn.application_service.model.Application;
import com.learnnbuildnlearn.application_service.model.Job;
import com.learnnbuildnlearn.application_service.model.Status;
import com.learnnbuildnlearn.application_service.repository.ApplicationRepository;
import com.learnnbuildnlearn.application_service.mapper.ApplicationMapper;
import com.learnnbuildnlearn.application_service.util.JobUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.learnnbuildnlearn.application_service.exception.ResourceNotFoundException;

import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ApplicationResponse trackApplication(UUID applicationId) {
        Optional<Application> application = applicationRepository.findById(applicationId);

        if(application.isPresent()) {
            return ApplicationMapper.toApplicationResponse(application.get());
        }

        throw new ResourceNotFoundException("application having id = " + applicationId + " not found");
    }

    public ApplicationResponse applyJob(UUID jobId) {
        Optional<Job> job = JobUtil.findJob(jobId);

        if(job.isPresent()) {
            Application newApplication = new Application();
            newApplication.setStatus(Status.APPLIED);
            newApplication.setJobId(jobId);
            newApplication.setRemarks("Application in queue");

            // fetch user id from token
            newApplication.setCreatedBy(UUID.fromString("a1e45678-1111-4a4d-aaaa-123456789008"));

            try {
                newApplication = applicationRepository.save(newApplication);
            }
            catch (DataIntegrityViolationException e) {
                throw new UniqueConstraintViolationException("you have already applied for this job");
            }

            return ApplicationMapper.toApplicationResponse(newApplication);
        }

        throw new ResourceNotFoundException("job having id = " + jobId + " not found");
    }
}
