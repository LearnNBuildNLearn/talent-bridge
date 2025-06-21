package com.learnnbuildnlearn.job_service.Repository;

import com.learnnbuildnlearn.job_service.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {


}
