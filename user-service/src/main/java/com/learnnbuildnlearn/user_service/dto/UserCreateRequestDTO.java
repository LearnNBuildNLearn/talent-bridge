package com.learnnbuildnlearn.user_service.dto;

import com.learnnbuildnlearn.user_service.entity.RoleType;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateRequestDTO {

    private String name;

    private LocalDate dob;

    private String password;

    private String phone;

    private String email;

    private String designation;
}
