package com.learnnbuildnlearn.application_service.mapper;

import com.learnnbuildnlearn.application_service.dto.ApplicationResponse;
import com.learnnbuildnlearn.application_service.model.Application;

public class ApplicationMapper {
    public static ApplicationResponse toApplicationResponse(Application application) {
        ApplicationResponse applicationResponse = new ApplicationResponse();

        applicationResponse.setId(application.getId());
        applicationResponse.setStatus(String.valueOf(application.getStatus()));
        applicationResponse.setJobId(application.getJobId());
        applicationResponse.setRemarks(application.getRemarks());
        applicationResponse.setCreatedOn(application.getCreatedOn());
        applicationResponse.setCreatedBy(application.getCreatedBy());
        applicationResponse.setModifiedOn(application.getModifiedOn());
        applicationResponse.setModifiedBy(application.getModifiedBy());

        return applicationResponse;
    }
}
