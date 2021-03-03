package com.gialinh.shop.service;

import com.gialinh.shop.domain.Account;
import com.gialinh.shop.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gialinh.shop.repository.spectification.AccountSpecification.CREATED_DATE;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_10:06 AM
 * @updatedAt 2/19/21_10:06 AM
 */
@Service
@AllArgsConstructor
public class AccountService implements IService<Account, String> {
    private final AccountRepository accountRepository;

    @Override
    public Page<Account> getAll(Specification<Account> specification, int page, int limit) {
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_DATE);
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        return accountRepository.findAll(specification, pageable);
    }

    @Override
    public Account findById(String id) {
        return accountRepository.getOne(id);
    }

    @Override
    public Account store(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> storeAll(List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }

    @Override
    public void delete(List<String> ids) {
        ids.forEach(accountRepository::deleteById);
    }

}
