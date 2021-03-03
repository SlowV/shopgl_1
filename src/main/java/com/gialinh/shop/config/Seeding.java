package com.gialinh.shop.config;

import com.gialinh.shop.domain.Account;
import com.gialinh.shop.domain.AccountInfo;
import com.gialinh.shop.domain.Role;
import com.gialinh.shop.domain.enumeration.Gender;
import com.gialinh.shop.repository.AccountRepository;
import com.gialinh.shop.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_10:45 AM
 * @updatedAt 2/19/21_10:45 AM
 */
@Component
@Slf4j
@AllArgsConstructor
public class Seeding {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @EventListener
    public void seed(ContextRefreshedEvent event) {
        this.createAccount();
    }

    private void createAccount() {
        if (!accountRepository.findAll().isEmpty()) {
            return;
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setFullName("Trịnh Quốc Việt");
        accountInfo.setAddress("63 Phú Đô, Mễ Trì, Từ Liêm, Hà Nội");
        accountInfo.setDob(LocalDate.of(1998, 2, 27));
        accountInfo.setGender(Gender.M);
        accountInfo.setPhone("034955602");
        try {
            BufferedImage bImage = ImageIO.read(new File(getClass().getClassLoader().getResource("avatar.jpg").toURI()));
            // get DataBufferBytes from Raster
            WritableRaster raster = bImage.getRaster();
            DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
            accountInfo.setAvatar(data.getData());
            accountInfo.setAvatarContentType("data:image/jpeg;base64 ");
        } catch (IOException e) {
            log.info(e.getMessage());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Account account = new Account()
                .email("quocviet.hn98@gmail.com")
                .password(passwordEncoder.encode("Viet1998"))
                .activated(true)
                .roles("ROLE_ADMIN", "ROLE_USER")
                .createdBy("SYSTEM");
        accountInfo.setAccount(account);

        roleRepository.saveAll(Arrays.asList(
                new Role("ROLE_ADMIN"),
                new Role("ROLE_USER")
        ));
        accountRepository.save(account.accountInfo(accountInfo));
    }
}
