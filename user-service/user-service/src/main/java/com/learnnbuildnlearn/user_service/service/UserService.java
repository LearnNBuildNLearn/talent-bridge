package com.learnnbuildnlearn.user_service.service;

import com.learnnbuildnlearn.user_service.dto.UserCreateRequestDTO;
import com.learnnbuildnlearn.user_service.entity.User;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
import java.util.UUID;

@EnableJpaAuditing
public  interface UserService {
    User createUser(UserCreateRequestDTO userDto);
    User getUserById(UUID id);
    List<User> getAllUsers();
    User updateUser(UUID id,UserCreateRequestDTO userDto);
    void deleteUser(UUID id);


}