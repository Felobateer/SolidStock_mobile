package com.solidstock.backend.service.impl;

import com.solidstock.backend.exception.InsufficientFundsException;
import com.solidstock.backend.exception.ResourceNotFoundException;
import com.solidstock.backend.model.dto.TransferRequestDto;
import com.solidstock.backend.model.dto.TransferResponseDto;
import com.solidstock.backend.model.entity.Account;
import com.solidstock.backend.repository.AccountRepository;
import com.solidstock.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public TransferResponseDto transferFunds(TransferRequestDto transferRequestDto) {
        String sourceAccountNumber = transferRequestDto.getSourceAccountNumber();
        String destinationAccountNumber = transferRequestDto.getDestinationAccountNumber();
        Double amount = transferRequestDto.getAmount();

        // Validate amount
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be greater than zero");
        }

        // Find source and destination accounts
        Account sourceAccount = accountRepository.findByAccountNumber(sourceAccountNumber);
        if (sourceAccount == null) {
            throw new ResourceNotFoundException("Source account not found with account number: " + sourceAccountNumber);
        }

        Account destinationAccount = accountRepository.findByAccountNumber(destinationAccountNumber);
        if (destinationAccount == null) {
            throw new ResourceNotFoundException("Destination account not found with account number: " + destinationAccountNumber);
        }

        // Check sufficient funds
        if (sourceAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds in source account with account number: " + sourceAccountNumber);
        }

        // Perform the transfer
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(destinationAccount);

        // Generate a transaction ID for tracking
        String transactionId = UUID.randomUUID().toString();

        return new TransferResponseDto(
                transactionId,
                "Transfer successful",
                sourceAccount.getBalance(),
                destinationAccount.getBalance()
        );
    }

}
