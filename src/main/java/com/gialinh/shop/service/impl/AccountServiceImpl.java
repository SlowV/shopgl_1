package com.gialinh.shop.service.impl;

import com.gialinh.shop.domain.Account;
import com.gialinh.shop.repository.AccountRepository;
import com.gialinh.shop.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_10:06 AM
 * @updatedAt 2/19/21_10:06 AM
 */
@Service
public class AccountServiceImpl implements AccountService {
    final
    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findById(email).orElse(null);
    }
}
