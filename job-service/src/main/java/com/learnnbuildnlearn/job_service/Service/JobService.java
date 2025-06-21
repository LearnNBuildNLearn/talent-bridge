package com.learnnbuildnlearn.job_service.Service;


import com.learnnbuildnlearn.job_service.DTO.JobRequestDTO;
import com.learnnbuildnlearn.job_service.DTO.JobResponseDTO;
import com.learnnbuildnlearn.job_service.Entity.Job;
import com.learnnbuildnlearn.job_service.Exception.JobNotFoundException;
import com.learnnbuildnlearn.job_service.Mapper.JobMapper;
import com.learnnbuildnlearn.job_service.Repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobResponseDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();

        return jobs.stream().map(JobMapper::toJobResponseDTO).toList();
    }

    public JobResponseDTO createJob(JobRequestDTO jobRequestDTO) {
        Job newJob = jobRepository.save(JobMapper.toJob(jobRequestDTO));

        return JobMapper.toJobResponseDTO(newJob);
    }

    public JobResponseDTO updateJob(UUID id, JobRequestDTO jobRequestDTO) {

        Job job = jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("Job not found with ID:"+ id));

        job.setJobDescription(jobRequestDTO.getJobDescription());
        job.setExperience(jobRequestDTO.getExperience());
        job.setClientName(jobRequestDTO.getClientName());
        job.setPosition(jobRequestDTO.getPosition());
        job.setLocation(jobRequestDTO.getLocation());
        job.setOpenings(jobRequestDTO.getOpenings());
        job.setPointOfContact(jobRequestDTO.getPointOfContact());
        job.setSkill(jobRequestDTO.getSkill());


        Job updatedJob = jobRepository.save(job);
        return JobMapper.toJobResponseDTO(updatedJob);
    }

    @Transactional(readOnly = true)
    public JobResponseDTO getJobById(UUID id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("Job not found with ID:"+ id));

        return JobMapper.toJobResponseDTO(job);
    }

    public void deleteJob(UUID id){
        jobRepository.deleteById(id);
    }
}
