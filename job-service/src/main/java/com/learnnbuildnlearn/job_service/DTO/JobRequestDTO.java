package com.learnnbuildnlearn.job_service.DTO;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class JobRequestDTO {

    @NotBlank(message = "location is required")
    private String location;

    @NotEmpty(message = "Skill set cannot be empty")
    private List<@NotBlank String> skill;

    @NotBlank(message = "job description is required ")
    private String jobDescription;

    @NotBlank(message ="client name is required")
    @Size(max=100, message = "client name cannot be greater than 100 character")
    private String clientName;

    @NotBlank(message ="position is required")
    @Size(max=100, message = "position cannot have more than 100 character")
    private String position;

    @NotBlank(message ="experience is required")
    @Positive(message ="experience must be a positive number")
    private double experience;

    @NotBlank(message ="Openings is required")
    @Min(value = 1,message = "There must be at least 1 opening")
    private int openings;

    @NotBlank(message = "point of contact is required")
    private String pointOfContact;
}
