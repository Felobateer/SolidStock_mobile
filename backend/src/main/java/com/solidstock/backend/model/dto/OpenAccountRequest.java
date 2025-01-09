package com.solidstock.backend.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OpenAccountRequest {
    private Long userId;
    private String accountType;
}
