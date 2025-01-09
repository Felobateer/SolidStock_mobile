package com.solidstock.backend.service.impl;

import com.solidstock.backend.exception.ResourceNotFoundException;
import com.solidstock.backend.mapper.UserMapper;
import com.solidstock.backend.model.dto.LoginRequest;
import com.solidstock.backend.model.dto.LoginResponse;
import com.solidstock.backend.model.dto.UserDto;
import com.solidstock.backend.model.entity.User;
import com.solidstock.backend.repository.UserRepository;
import com.solidstock.backend.service.UserService;
import com.solidstock.backend.config.SecurityConfig;
import com.solidstock.backend.utils.JwtUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    @Cacheable(value = "users", key = "#id")
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User not found with id: " + id));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUserData(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User not found with id: " + id));


        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPhoneNumber(userDto.getPhoneNumber());
        existingUser.setAddress(userDto.getAddress());
        existingUser.setPostalCode(userDto.getPostalCode());
        existingUser.setCity(userDto.getCity());
        existingUser.setCountry(userDto.getCountry());
        existingUser.setNationality(userDto.getNationality());
        existingUser.setJoinedAt(userDto.getJoinedAt());

        User updatedUser = userRepository.save(existingUser);

        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUserData(Long id) {
        User formerUser = userRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(formerUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) ->
                UserMapper.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(user.getEmail());

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setId(user.getId());
        response.setUsername(user.getFirstName() + " " + user.getLastName());
        response.setEmail(user.getEmail());
        return response;
    }


}
