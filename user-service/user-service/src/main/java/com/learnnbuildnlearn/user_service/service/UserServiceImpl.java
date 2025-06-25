package com.learnnbuildnlearn.user_service.service;

import com.learnnbuildnlearn.user_service.dto.UserCreateRequestDTO;
import com.learnnbuildnlearn.user_service.entity.User;
import com.learnnbuildnlearn.user_service.exception.ResourceNotFoundException;
import com.learnnbuildnlearn.user_service.repository.UserRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserCreateRequestDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        User user = toEntity(dto);
        return userRepository.save(user);
    }


    @Override
    public User getUserById(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id" + id));
    }

    @Override
    public User updateUser(UUID id,UserCreateRequestDTO dto){
        User user = getUserById(id);
        user.setName(dto.getName());
        user.setDob(dto.getDob());
        user.setPassword(dto.getPassword());
        user.setApplications(dto.getApplications());
        user.setSkills(dto.getSkills());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setResumeLink(dto.getResumeLink());
        user.setRole(dto.getRole());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    private User toEntity(UserCreateRequestDTO dto) {
        return User.builder()
                .name(dto.getName())
                .dob(dto.getDob())
                .password(dto.getPassword())
                .applications(dto.getApplications())
                .skills(dto.getSkills())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .resumeLink(dto.getResumeLink())
                .role(dto.getRole())
                .build();
}
}
