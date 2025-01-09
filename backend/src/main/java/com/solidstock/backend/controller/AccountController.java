package com.solidstock.backend.controller;

import com.solidstock.backend.exception.ResourceNotFoundException;
import com.solidstock.backend.mapper.AccountMapper;
import com.solidstock.backend.model.dto.AccountDto;
import com.solidstock.backend.model.dto.NotificationDto;
import com.solidstock.backend.model.dto.OpenAccountRequest;
import com.solidstock.backend.model.entity.Account;
import com.solidstock.backend.model.entity.User;
import com.solidstock.backend.repository.UserRepository;
import com.solidstock.backend.service.AccountService;
import com.solidstock.backend.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserRepository userRepository;

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
    public ResponseEntity<AccountDto> openAccount(@RequestBody @Valid OpenAccountRequest openAccountRequest) {
        // Open the account
        AccountDto newAccount = accountService.openAccount(openAccountRequest);
        User user = userRepository.findById(newAccount.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        // Prepare notification message
        String message = String.format(
                "A new %s account has been successfully opened. Account Number: %s.",
                newAccount.getAccountType(),
                newAccount.getAccountNumber()
        );
        Account _newAccount = AccountMapper.toEntity(newAccount, user);
        String recipient = _newAccount.getUser().getEmail(); // Assuming user email is available in the associated UserDto

        // Create and send notification
        NotificationDto notificationDto = new NotificationDto(
                message,
                recipient,
                _newAccount.getUser().getId()
        );
        notificationService.addNewNotification(notificationDto);

        return ResponseEntity.ok(newAccount);
    }

    /**
     * Delete an account by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        // Fetch the account details for notification before deletion
        AccountDto account = accountService.getAccountById(id);
        User user = userRepository.findById(account.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("user not found"));
        // Delete the account
        accountService.deleteAccount(id);

        // Prepare notification message
        String message = String.format(
                "Your %s account with Account Number: %s has been successfully deleted.",
                account.getAccountType(),
                account.getAccountNumber()
        );
        String recipient = user.getEmail(); // Assuming user email is available in the associated UserDto

        // Create and send notification
        NotificationDto notificationDto = new NotificationDto(
                message,
                recipient,
                user.getId()
        );
        notificationService.addNewNotification(notificationDto);

        return ResponseEntity.noContent().build();
    }

}
