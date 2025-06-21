package com.learnnbuildnlearn.job_service.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobResponseDTO {

    private UUID jobId;
    private String location;
    private List<String> skill;
    private String jobDescription;
    private String clientName;
    private String position;
    private double experience;
    private int openings;
    private String pointOfContact;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
