package com.gialinh.shop.config;

import com.gialinh.shop.domain.Account;
import com.gialinh.shop.domain.AccountInfo;
import com.gialinh.shop.domain.enumeration.Gender;
import com.gialinh.shop.repository.AccountRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_10:45 AM
 * @updatedAt 2/19/21_10:45 AM
 */
@Component
public class Seeding {
    final
    AccountRepository accountRepository;

    final
    PasswordEncoder passwordEncoder;

    public Seeding(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        this.createAccount();
    }

    private void createAccount() {
        if (accountRepository.findAll().size() > 0) {
            return;
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setFullName("Trịnh Quốc Việt");
        accountInfo.setAddress("63 Phú Đô, Mễ Trì, Từ Liêm, Hà Nội");
        accountInfo.setDob(LocalDate.of(1998, 2, 27));
        accountInfo.setGender(Gender.M);
        accountInfo.setPhone("034955602");
        accountInfo.setAvatarURL("https://avatars.githubusercontent.com/u/31509114");
        Account account = new Account()
                .email("quocviet.hn98@gmail.com")
                .password(passwordEncoder.encode("Viet1998"))
                .activated(true)
                .roles("ADMIN", "USER")
                .createdBy("ADMIN_SYSTEM");
        accountInfo.setAccount(account);
        accountRepository.save(account.accountInfo(accountInfo));
    }
}
