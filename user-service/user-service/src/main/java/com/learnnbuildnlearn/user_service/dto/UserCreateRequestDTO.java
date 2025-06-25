package com.learnnbuildnlearn.user_service.dto;

import com.learnnbuildnlearn.user_service.entity.AccountType;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDTO {

    private String name;

    private LocalDate dob;

    private String password;

    private List<UUID> applications;

    private List<String> skills;

    private String phone;

    private String email;

    private String resumeLink;

    private AccountType role;

    private LocalDateTime createdOn;

    private UUID createdBy;

    private LocalDateTime modifiedOn;

    private UUID modifiedBy;

}
