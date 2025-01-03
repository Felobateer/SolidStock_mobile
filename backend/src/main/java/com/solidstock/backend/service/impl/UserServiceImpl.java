package com.solidstock.backend.service.impl;

import com.solidstock.backend.mapper.UserMapper;
import com.solidstock.backend.model.dto.UserDto;
import com.solidstock.backend.model.entity.User;
import com.solidstock.backend.repository.UserRepository;
import com.solidstock.backend.service.UserService;
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
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUserData(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException(("User not found")));


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
        User formerUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException(("User not found")));
        userRepository.delete(formerUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());
    }


}
