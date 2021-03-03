package com.gialinh.shop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_1:27 PM
 * @updatedAt 2/5/21_1:27 PM
 * <p>
 * Class entity Authority {@link Role}
 */
@Getter
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 50)
    private String name;

    public String getStyleByRole() {
        if (ROLE.ROLE_ADMIN.toString().equals(this.name)) {
            return ROLE.ROLE_ADMIN.getStyle();
        }
        return ROLE.ROLE_USER.getStyle();
    }

    public String getNameDisplayByRole() {
        if (ROLE.ROLE_ADMIN.toString().equals(this.name)) {
            return ROLE.ROLE_ADMIN.getName();
        }

        if (ROLE.ROLE_USER.toString().equals(this.name)) {
            return ROLE.ROLE_USER.getName();
        }
        return "Không có";
    }

    @Getter
    enum ROLE {
        ROLE_ADMIN("Quản lý", "color: #ffffff;background-color: #2196f3;"), ROLE_USER("Nhân viên", "color: #ffffff;background-color: #6c757d;");
        private String name;
        private String style;

        ROLE(String name, String style) {
            this.name = name;
            this.style = style;
        }
    }
}
