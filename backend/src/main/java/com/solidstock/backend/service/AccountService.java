package com.solidstock.backend.service;

import com.solidstock.backend.model.dto.AccountDto;
import com.solidstock.backend.model.dto.OpenAccountRequest;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccounts();
    List<AccountDto> getUserAccounts(Long userId);
    AccountDto getAccountById(Long id);
    AccountDto getAccountByAccountNumber(String accountNumber);
    AccountDto openAccount(OpenAccountRequest openAccountRequest);
    void deleteAccount(Long id);
}
