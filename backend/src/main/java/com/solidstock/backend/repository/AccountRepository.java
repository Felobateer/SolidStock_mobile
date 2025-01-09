package com.solidstock.backend.repository;

import com.solidstock.backend.model.entity.Account;
import com.solidstock.backend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
    List<Account> findByUser(User user);
}
