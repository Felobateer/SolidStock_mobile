package com.solidstock.backend.controller;

import com.solidstock.backend.model.dto.AccountDto;
import com.solidstock.backend.model.dto.OpenAccountRequest;
import com.solidstock.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;


    /**
     * Get all accounts.
     */
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    /**
     * Get all accounts for a specific user.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AccountDto>> getUserAccounts(@PathVariable Long userId) {
        List<AccountDto> userAccounts = accountService.getUserAccounts(userId);
        return ResponseEntity.ok(userAccounts);
    }

    /**
     * Get account by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    /**
     * Get account by account number.
     */
    @GetMapping("/account-number/{accountNumber}")
    public ResponseEntity<AccountDto> getAccountByAccountNumber(@PathVariable String accountNumber) {
        AccountDto account = accountService.getAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok(account);
    }

    /**
     * Open a new account with a request body.
     */
    @PostMapping("/open")
    public ResponseEntity<AccountDto> openAccount(@RequestBody OpenAccountRequest openAccountRequest) {
        AccountDto newAccount = accountService.openAccount(openAccountRequest);
        return ResponseEntity.ok(newAccount);
    }

    /**
     * Delete an account by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
