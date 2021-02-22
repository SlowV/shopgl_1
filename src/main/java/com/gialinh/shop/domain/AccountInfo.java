package com.gialinh.shop.domain;

import com.gialinh.shop.domain.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_1:16 PM
 * @updatedAt 2/5/21_1:16 PM
 *
 * Class entity AccountInfo {@link com.gialinh.shop.domain.AccountInfo}
 */
@Entity
@Table(name = "account_info")
@Getter
@Setter
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

    @Column(name = "avatar_url", nullable = false)
    private String avatarURL;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountInfo)) return false;
        AccountInfo that = (AccountInfo) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFullName(), that.getFullName()) &&
                Objects.equals(getDob(), that.getDob()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getAvatarURL(), that.getAvatarURL()) &&
                getGender() == that.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getDob(), getAddress(), getPhone(), getAvatarURL(), getGender());
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", avatarURL='" + avatarURL + '\'' +
                ", gender=" + gender +
                '}';
    }
}
