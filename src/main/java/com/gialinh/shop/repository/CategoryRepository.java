package com.gialinh.shop.repository;

import com.gialinh.shop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author SlowV
 * @createdAt 3/1/21_4:25 PM
 * @updatedAt 3/1/21_4:25 PM
 * @description
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
}
