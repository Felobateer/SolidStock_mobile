package com.solidstock.backend.service;

import com.solidstock.backend.model.dto.TransferRequestDto;
import com.solidstock.backend.model.dto.TransferResponseDto;

public interface PaymentService {
    TransferResponseDto transferFunds(TransferRequestDto transferRequestDto);
}
