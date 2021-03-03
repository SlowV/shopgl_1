package com.gialinh.shop.repository.spectification;

import com.gialinh.shop.domain.Account;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author SlowV
 * @createdAt 2/24/21_5:18 PM
 * @updatedAt 2/24/21_5:18 PM
 * @description
 */
@NoArgsConstructor
public final class AccountSpecification {
    public static final String EMAIL = "email";
    public static final String CREATED_VY = "createdBy";
    public static final String CREATED_DATE = "createdDate";
    public static final String LAST_MODIFIED_BY = "lastModifiedBy";
    public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
    public static final String ACTIVATED = "activated";
    public static final String PASSWORD = "password";

    public static <T> Specification<T> where(Specification<T> specification, Specification<T> condition) {
        return specification == null ? Specification.where(condition) :
                specification.and(condition);
    }

    public static Specification<Account> email(String email) {
        if (Strings.isBlank(email)) {
            return null;
        }
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.upper(root.get(EMAIL)), like(email));
    }

    private static String like(String value) {
        return "%" + value.toUpperCase() + "%";
    }

}
