package com.gialinh.shop.domain;

import com.gialinh.shop.domain.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_1:16 PM
 * @updatedAt 2/5/21_1:16 PM
 *
 * Class entity AccountInfo {@link com.gialinh.shop.domain.AccountInfo}
 */
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_info")
public class AccountInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Lob
    @Column(name = "avatar", nullable = false)
    private byte[] avatar;

    @Column(name = "avatar_content_type", nullable = false)
    private String avatarContentType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne
    private Account account;

    public String getImageBase64() {
        return this.avatarContentType + ", " + Base64.getEncoder().encodeToString(this.avatar);
    }
}
