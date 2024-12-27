package com.solidstock.backend.mapper;

import com.solidstock.backend.model.dto.UserDto;
import com.solidstock.backend.model.entity.User;


public class UserMapper {
    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getPhoneNumber(),
                userDto.getAddress(),
                userDto.getPostalCode(),
                userDto.getCity(),
                userDto.getCountry(),
                userDto.getNationality(),
                userDto.getJoinedAt(),
                userDto.getPremium()
        );
        return user;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getPostalCode(),
                user.getCity(),
                user.getCountry(),
                user.getNationality(),
                user.getJoinedAt(),
                user.getPremium()
        );
        return userDto;
    }
}
