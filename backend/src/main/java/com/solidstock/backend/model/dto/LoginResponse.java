package com.solidstock.backend.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private String username;
    private String email;
    private Long id;
}
