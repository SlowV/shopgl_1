package com.gialinh.shop.repository;

import com.gialinh.shop.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SlowV
 * @createdAt 3/1/21_4:27 PM
 * @updatedAt 3/1/21_4:27 PM
 * @description
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
