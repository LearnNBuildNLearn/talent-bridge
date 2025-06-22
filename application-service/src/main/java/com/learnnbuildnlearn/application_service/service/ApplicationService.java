package com.learnnbuildnlearn.application_service.service;

import com.learnnbuildnlearn.application_service.dto.ApplicationResponse;
import com.learnnbuildnlearn.application_service.exception.UniqueConstraintViolationException;
import com.learnnbuildnlearn.application_service.feign.JobFeignClient;
import com.learnnbuildnlearn.application_service.feign.exception.JobException;
import com.learnnbuildnlearn.application_service.feign.exception.JobServiceUnavailableException;
import com.learnnbuildnlearn.application_service.feign.model.JobResponse;
import com.learnnbuildnlearn.application_service.model.Application;
import com.learnnbuildnlearn.application_service.model.Job;
import com.learnnbuildnlearn.application_service.model.Status;
import com.learnnbuildnlearn.application_service.repository.ApplicationRepository;
import com.learnnbuildnlearn.application_service.mapper.ApplicationMapper;
import com.learnnbuildnlearn.application_service.util.JobUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.learnnbuildnlearn.application_service.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final JobFeignClient jobFeignClient;

    ApplicationService(ApplicationRepository applicationRepository, JobFeignClient jobFeignClient) {
        this.applicationRepository = applicationRepository;
        this.jobFeignClient = jobFeignClient;
    }

    public ApplicationResponse trackApplication(UUID applicationId) {
        Optional<Application> application = applicationRepository.findById(applicationId);

        if(application.isPresent()) {
            return ApplicationMapper.toApplicationResponse(application.get());
        }

        throw new ResourceNotFoundException("application having id = " + applicationId + " not found");
    }

    public List<ApplicationResponse> getAllApplication() {
        // get user id from token
        UUID userId = UUID.fromString("a6dcb473-bee8-47c6-be62-1021f4597c63");

        List<Application> applications = applicationRepository.findByCreatedBy(userId);

        return applications.stream().map(ApplicationMapper::toApplicationResponse).toList();
    }

    public ApplicationResponse applyJob(UUID jobId) {
        try{
            JobResponse jobResponse = jobFeignClient.getJobById(jobId);

            if (jobResponse == null || !jobResponse.isActive()) {
                throw new JobException("job not available or inactive");
            }
        }
        catch (Exception e) {
            throw new JobServiceUnavailableException("job-service is down. Cannot fetch job with id : " + jobId);
        }

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

    public ApplicationResponse updateStatus(UUID applicationId, Status newStatus) {
        Optional<Application> application = applicationRepository.findById(applicationId);

        if(application.isPresent()) {
            application.get().setStatus(newStatus);
            return ApplicationMapper.toApplicationResponse(applicationRepository.save(application.get()));
        }

        throw new ResourceNotFoundException("application having id = " + applicationId + " not found");
    }
}
