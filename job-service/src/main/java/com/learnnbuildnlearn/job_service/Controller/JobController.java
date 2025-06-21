package com.learnnbuildnlearn.job_service.Controller;


import com.learnnbuildnlearn.job_service.DTO.JobRequestDTO;
import com.learnnbuildnlearn.job_service.DTO.JobResponseDTO;
import com.learnnbuildnlearn.job_service.Service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobResponseDTO>> getJobs(){
        List<JobResponseDTO> jobs = jobService.getAllJobs();

        return ResponseEntity.ok().body(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDTO> getJobById( @PathVariable UUID id){
        JobResponseDTO job = jobService.getJobById(id);

        return ResponseEntity.ok().body(job);
    }

    @PostMapping
    public ResponseEntity<JobResponseDTO> createJob(@RequestBody JobRequestDTO jobRequestDTO){
        JobResponseDTO jobResponseDTO = jobService.createJob(jobRequestDTO);

        return ResponseEntity.ok().body(jobResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobResponseDTO> updateJob(
            @PathVariable UUID id,
            @RequestBody JobRequestDTO jobRequestDTO){
        JobResponseDTO jobResponseDTO = jobService.updateJob(id,jobRequestDTO);

        return ResponseEntity.ok().body(jobResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable UUID id){
        jobService.deleteJob(id);

        return ResponseEntity.noContent().build();
    }

}
