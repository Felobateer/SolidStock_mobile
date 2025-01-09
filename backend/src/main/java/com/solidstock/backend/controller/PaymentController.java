package com.solidstock.backend.controller;

import com.solidstock.backend.model.dto.TransferRequestDto;
import com.solidstock.backend.model.dto.TransferResponseDto;
import com.solidstock.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * Transfer funds between two accounts.
     *
     * @param transferRequestDto contains details for the transfer (source, destination, amount).
     * @return TransferResponseDto with the result of the transfer.
     */
    @PostMapping("/transfer")
    public ResponseEntity<TransferResponseDto> transferFunds(@RequestBody TransferRequestDto transferRequestDto) {
        TransferResponseDto response = paymentService.transferFunds(transferRequestDto);
        return ResponseEntity.ok(response);
    }
}
