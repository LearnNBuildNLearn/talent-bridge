package com.learnnbuildnlearn.application_service.util;

import com.learnnbuildnlearn.application_service.model.Job;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JobUtil {
    public static Optional<Job> findJob(UUID jobId) {
        List<String> uuidStrings = Arrays.asList(
                "123e4567-e89b-12d3-a456-426614174000",
                "223e4567-e89b-12d3-a456-426614174001"
        );

        List<UUID> uuidList = uuidStrings.stream()
                .map(UUID::fromString)
                .toList();

        if(uuidList.contains(jobId)) {
            return Optional.of(new Job(jobId));
        }

        return Optional.empty();
    }
}
