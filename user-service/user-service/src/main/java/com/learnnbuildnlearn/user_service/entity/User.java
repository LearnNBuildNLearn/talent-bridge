package com.learnnbuildnlearn.user_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learnnbuildnlearn.user_service.Base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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

        private String name;
        private LocalDate dob;

//    avoid leaking password in API responses
        @JsonIgnore
        private String password;

//       generate a separate join tabl
//       “This field is a collection of simple elements that should be stored in a separate table linked to the owning entity.”
        @ElementCollection
        private List<UUID> applications;

//    generate a separate join table
        @ElementCollection
        private List<String> skills;

        @Size(min =10 , max = 15)
        private String phone;
        //database enforced is unqiue
        @Email
        @Column(unique = true)
        private String email;

        private String resumeLink;

        @Enumerated(EnumType.STRING)
        private AccountType role;



}