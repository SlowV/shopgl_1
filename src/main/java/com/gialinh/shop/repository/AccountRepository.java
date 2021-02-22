package com.gialinh.shop.repository;

import com.gialinh.shop.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_10:04 AM
 * @updatedAt 2/19/21_10:04 AM
 */
public interface AccountRepository extends JpaRepository<Account, String> {
}
