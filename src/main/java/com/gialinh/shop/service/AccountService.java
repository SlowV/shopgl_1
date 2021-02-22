package com.gialinh.shop.service;

import com.gialinh.shop.domain.Account;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_10:05 AM
 * @updatedAt 2/19/21_10:05 AM
 */
public interface AccountService {
    Account findByEmail(String email);
}
