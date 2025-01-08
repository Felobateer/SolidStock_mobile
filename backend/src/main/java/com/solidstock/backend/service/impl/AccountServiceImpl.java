package com.solidstock.backend.service.impl;

import com.solidstock.backend.model.entity.Account;
import com.solidstock.backend.model.entity.User;
import com.solidstock.backend.repository.AccountRepository;
import com.solidstock.backend.repository.UserRepository;
import com.solidstock.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public Account createAccount(Long userId, String accountNumber, String accountType, Double balance) {
        User user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("user not found"));

        Account bankAccount = new Account();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setAccountType(accountType);
        bankAccount.setBalance(balance);
        bankAccount.setUser(user);

        return accountRepository.save(bankAccount);
    }
}
