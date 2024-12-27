package com.solidstock.backend.service.impl;

import com.solidstock.backend.mapper.UserMapper;
import com.solidstock.backend.model.dto.UserDto;
import com.solidstock.backend.model.entity.User;
import com.solidstock.backend.repository.UserRepository;
import com.solidstock.backend.service.UserService;
import org.springframework.stereotype.Service;

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
}
