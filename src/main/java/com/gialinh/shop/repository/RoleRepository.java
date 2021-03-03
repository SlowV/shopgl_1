package com.gialinh.shop.repository;

import com.gialinh.shop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SlowV
 * @createdAt 3/1/21_4:29 PM
 * @updatedAt 3/1/21_4:29 PM
 * @description
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
