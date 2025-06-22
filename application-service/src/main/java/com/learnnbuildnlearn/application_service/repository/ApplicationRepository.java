package com.learnnbuildnlearn.application_service.repository;

import com.learnnbuildnlearn.application_service.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> findByCreatedBy(UUID createdBy);
}
