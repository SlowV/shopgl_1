package com.gialinh.shop.repository;

import com.gialinh.shop.domain.Account;
import com.gialinh.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author SlowV
 * @createdAt 3/2/21_1:43 PM
 * @updatedAt 3/2/21_1:43 PM
 * @description
 */
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
