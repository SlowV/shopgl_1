package com.gialinh.shop.repository;

import com.gialinh.shop.domain.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author SlowV
 * @createdAt 3/1/21_4:22 PM
 * @updatedAt 3/1/21_4:22 PM
 * @description
 */
@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
