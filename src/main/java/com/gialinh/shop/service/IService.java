package com.gialinh.shop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * @author SlowV
 * @createdAt 3/2/21_1:23 PM
 * @updatedAt 3/2/21_1:23 PM
 * @description
 */
public interface IService<T, K> {
    Page<T> getAll(Specification<T> specification, int page, int limit);

    T findById(K id);

    T store(T t);

    List<T> storeAll(List<T> t);

    void delete(List<K> ids);
}
