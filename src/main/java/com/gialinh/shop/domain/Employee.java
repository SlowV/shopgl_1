package com.gialinh.shop.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_1:36 PM
 * @updatedAt 2/5/21_1:36 PM
 * <p>
 * Class entity Employee {@link com.gialinh.shop.domain.Employee}
 */
@Entity
@Table(
        name = "employees",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"emp_roll"}
        )
)
@Getter
@Setter
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


    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) &&
                Objects.equals(getIdCardFront(), employee.getIdCardFront()) &&
                Objects.equals(getIdCardBack(), employee.getIdCardBack()) &&
                Objects.equals(getFace(), employee.getFace()) &&
                Objects.equals(empRoll, employee.empRoll) &&
                Objects.equals(getBankNumber(), employee.getBankNumber()) &&
                Objects.equals(getBankName(), employee.getBankName()) &&
                Objects.equals(getBankCustomerName(), employee.getBankCustomerName()) &&
                Objects.equals(getBankBranch(), employee.getBankBranch()) &&
                Objects.equals(getJoinDate(), employee.getJoinDate());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", idCardFront='" + idCardFront + '\'' +
                ", idCardBack='" + idCardBack + '\'' +
                ", face='" + face + '\'' +
                ", empRoll='" + empRoll + '\'' +
                ", bankNumber='" + bankNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankCustomerName='" + bankCustomerName + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}
