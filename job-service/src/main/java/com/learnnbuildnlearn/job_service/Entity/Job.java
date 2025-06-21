package com.learnnbuildnlearn.job_service.Entity;

import com.learnnbuildnlearn.job_service.Base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Job extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID jobId;
    private String location;
    private List<String> skill;
    private String jobDescription;
    private String clientName;
    private String position;
    private double experience;
    private int openings;
    private String pointOfContact;
    private int JobExpiry = 30;

    public Job(UUID jobId, String location, List<String> skill, String jobDescription, String clientName, String position, double experience, int openings, String pointOfContact) {
        this.jobId = jobId;
        this.location = location;
        this.skill = skill;
        this.jobDescription = jobDescription;
        this.clientName = clientName;
        this.position = position;
        this.experience = experience;
        this.openings = openings;
        this.pointOfContact = pointOfContact;
    }

}
