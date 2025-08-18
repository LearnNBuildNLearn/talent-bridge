package com.learnnbuildnlearn.auth_service.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private String message;
}
