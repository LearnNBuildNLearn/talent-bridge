package com.learnnbuildnlearn.job_service.Mapper;

import com.learnnbuildnlearn.job_service.DTO.JobRequestDTO;
import com.learnnbuildnlearn.job_service.DTO.JobResponseDTO;
import com.learnnbuildnlearn.job_service.Entity.Job;

public class JobMapper {

    public static JobResponseDTO toJobResponseDTO(Job job) {

        return JobResponseDTO.builder()
                .jobId(job.getJobId())
                .jobDescription(job.getJobDescription())
                .clientName(job.getClientName())
                .experience(job.getExperience())
                .location(job.getLocation())
                .openings(job.getOpenings())
                .skill(job.getSkill())
                .position(job.getPosition())
                .pointOfContact(job.getPointOfContact())
                .createdAt(job.getCreatedAt())
                .createdBy(job.getCreatedBy())
                .updatedAt(job.getUpdatedAt())
                .updatedBy(job.getUpdatedBy())
                .build();

    }

    public static Job toJob(JobRequestDTO jobRequestDTO) {
        return Job.builder()
                .jobDescription(jobRequestDTO.getJobDescription())
                .clientName(jobRequestDTO.getClientName())
                .experience(jobRequestDTO.getExperience())
                .location(jobRequestDTO.getLocation())
                .openings(jobRequestDTO.getOpenings())
                .skill(jobRequestDTO.getSkill())
                .position(jobRequestDTO.getPosition())
                .pointOfContact(jobRequestDTO.getPointOfContact())
                .build();
    }
}
