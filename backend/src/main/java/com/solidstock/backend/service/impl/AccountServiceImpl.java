package com.solidstock.backend.service.impl;

import com.solidstock.backend.exception.ResourceNotFoundException;
import com.solidstock.backend.mapper.AccountMapper;
import com.solidstock.backend.model.dto.AccountDto;
import com.solidstock.backend.model.dto.OpenAccountRequest;
import com.solidstock.backend.model.entity.Account;
import com.solidstock.backend.model.entity.User;
import com.solidstock.backend.repository.AccountRepository;
import com.solidstock.backend.repository.UserRepository;
import com.solidstock.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;


    public Account createAccount(Long userId, String accountNumber, String accountType, Double balance) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User with ID " + userId + " not found"));

        Account bankAccount = new Account();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setAccountType(accountType);
        bankAccount.setBalance(balance);
        bankAccount.setUser(user);
        bankAccount.setCreatedAt(LocalDate.now());
        bankAccount.setUpdatedAt(LocalDate.now());

        return accountRepository.save(bankAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AccountMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountDto> getUserAccounts(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                 new ResourceNotFoundException("User not found with id: " + userId));

        List<Account> accounts = accountRepository.findByUser(user);
        if (accounts.isEmpty()) {
            throw new ResourceNotFoundException("No accounts found for user with ID " + userId);
        }

        List<AccountDto> = restTemplate.getForObject(dotenv.secondary_instance, List<AccountDto>.class);

        return accounts.stream()
                .map(AccountMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Account with ID " + id + " not found"));

        return AccountMapper.toDto(account);
    }

    @Override
    public AccountDto getAccountByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new ResourceNotFoundException("Account with account number " + accountNumber + " not found");
        }
        return AccountMapper.toDto(account);
    }

    @Override
    public AccountDto openAccount(OpenAccountRequest openAccountRequest) {
        // Generate a random account number (you can replace this logic with a better method)
        String accountNumber = "ACCT-" + System.currentTimeMillis();

        LocalDate currentTime = LocalDate.now();

        Account newAccount = new Account();
        User user = userRepository.findById(openAccountRequest.getUserId()).orElseThrow(() ->
                new ResourceNotFoundException("User with ID " + openAccountRequest.getUserId() + " not found"));

        newAccount.setUser(user);
        newAccount.setAccountType(openAccountRequest.getAccountType());
        newAccount.setAccountNumber(accountNumber);
        newAccount.setBalance(0.0); // Default balance
        newAccount.setCreatedAt(currentTime);
        newAccount.setUpdatedAt(currentTime);

        Account savedAccount = accountRepository.save(newAccount);
        return AccountMapper.toDto(savedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Account with ID " + id + " not found"));
        accountRepository.delete(account);
    }
}
