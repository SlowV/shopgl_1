package com.gialinh.shop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_1:36 PM
 * @updatedAt 2/5/21_1:36 PM
 * <p>
 * Class entity Employee {@link com.gialinh.shop.domain.Employee}
 */
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "employees",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"emp_roll"}
        )
)
public class Employee extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_card_front", nullable = false)
    private String idCardFront;

    @Column(name = "id_card_back", nullable = false)
    private String idCardBack;

    @Column(name = "face", nullable = false)
    private String face;

    @Column(name = "emp_roll", nullable = false, unique = true)
    private String empRoll;

    @Column(name = "bank_number")
    private String bankNumber;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_customer_name")
    private String bankCustomerName;

    @Column(name = "bank_branch")
    private String bankBranch;

    @CreatedDate
    @Column(name = "join_date")
    private Instant joinDate = Instant.now();

    @OneToOne
    private Account account;

}
