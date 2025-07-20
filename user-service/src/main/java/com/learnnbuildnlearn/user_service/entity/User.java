package com.learnnbuildnlearn.user_service.entity;

import com.learnnbuildnlearn.user_service.Base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name= "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
    public class User extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private LocalDate dob;

        @Column(nullable = false)
        private String password;

        private List<UUID> applications;

        private List<String> skills;

        @Size(min = 10)
        @Column(unique = true, nullable = false)
        private String phoneNumber;

        @Column(unique = true, nullable = false)
        private String email;

        private String resumeLink;

        private RoleType role;
}