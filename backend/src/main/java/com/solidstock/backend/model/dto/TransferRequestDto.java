package com.solidstock.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDto {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private Double amount;
    private String message;
}
