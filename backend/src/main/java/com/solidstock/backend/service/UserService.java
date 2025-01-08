package com.solidstock.backend.service;

import com.solidstock.backend.model.dto.LoginRequest;
import com.solidstock.backend.model.dto.LoginResponse;
import com.solidstock.backend.model.dto.UserDto;
import com.solidstock.backend.model.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    UserDto updateUserData(Long id, UserDto userDto);
    void deleteUserData(Long id);
    List<UserDto> getAllUsers();
    LoginResponse login(LoginRequest loginRequest);
}
