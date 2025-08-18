package com.learnnbuildnlearn.auth_service.service;

import com.learnnbuildnlearn.auth_service.exception.UserNotFoundException;
import com.learnnbuildnlearn.auth_service.model.User;
import com.learnnbuildnlearn.auth_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get user from user-service using web client
    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()) {
            throw new UserNotFoundException("user not found");
        }

        return user;
    }
}
