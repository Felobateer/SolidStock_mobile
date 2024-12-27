package com.solidstock.backend.service;

import com.solidstock.backend.model.dto.UserDto;
import com.solidstock.backend.model.entity.User;

public interface UserService {
    UserDto createUser(UserDto userDto);

}
