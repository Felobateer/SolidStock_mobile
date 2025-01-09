package com.solidstock.backend.mapper;

import com.solidstock.backend.model.dto.AccountDto;
import com.solidstock.backend.model.entity.Account;
import com.solidstock.backend.model.entity.User;

public class AccountMapper {
    public static AccountDto toDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getUser().getId(), // Get only the user ID
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }

    public static Account toEntity(AccountDto accountDto, User user) {
        return new Account(
                accountDto.getId(),
                accountDto.getAccountNumber(),
                accountDto.getAccountType(),
                accountDto.getBalance(),
                user, // Set the user object explicitly
                accountDto.getCreatedAt(),
                accountDto.getUpdatedAt()
        );
    }
}
