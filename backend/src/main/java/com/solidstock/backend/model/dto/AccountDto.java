package com.solidstock.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AccountDto {
    private final Long id;
    private final String accountNumber;
    private final String accountType;
    private final Double balance;
    private final Long userId;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private final LocalDate createdAt;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private final LocalDate updatedAt;

}
