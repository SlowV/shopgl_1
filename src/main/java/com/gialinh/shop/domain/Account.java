package com.gialinh.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_1:08 PM
 * @updatedAt 2/5/21_1:08 PM
 * <p>
 * Class entity Account {@link com.gialinh.shop.domain.Account}
 */
@Entity
@Table(name = "accounts")
@Setter
@Getter
public class Account extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "activated", nullable = false)
    private boolean activated = false;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "accounts_authority",
            joinColumns = {@JoinColumn(name = "accounts_email", referencedColumnName = "email")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();
    @OneToOne
    private AccountInfo accountInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        return Objects.equals(email, ((Account) o).email);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activated=" + activated +
                '}';
    }
}
