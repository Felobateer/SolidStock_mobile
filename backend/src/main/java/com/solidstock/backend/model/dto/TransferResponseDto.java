package com.solidstock.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponseDto {
    private String transactionId;
    private String message;
    private Double sourceAccountBalance;
    private Double destinationAccountBalance;
}
