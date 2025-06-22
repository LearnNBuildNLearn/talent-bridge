package com.learnnbuildnlearn.application_service.feign.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class JobResponse {
    private UUID id;
    private String title;
    private String description;
    private boolean active;
}
