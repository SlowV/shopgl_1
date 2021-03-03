package com.gialinh.shop.service;

import com.gialinh.shop.domain.Category;
import com.gialinh.shop.domain.Product;
import com.gialinh.shop.domain.enumeration.Status;
import com.gialinh.shop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gialinh.shop.repository.spectification.AccountSpecification.CREATED_DATE;

/**
 * @author SlowV
 * @createdAt 3/2/21_5:08 PM
 * @updatedAt 3/2/21_5:08 PM
 * @description
 */
@Service
@AllArgsConstructor
public class CategoryService implements IService<Category, Long> {
    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAll(Specification<Category> specification, int page, int limit) {
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_DATE);
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        return categoryRepository.findAll(specification, pageable);
    }

    public List<Category> categoriesNonFilter() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public Category store(Category category) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return categoryRepository.save(category.created_by(authentication.getName()));
    }

    @Override
    public List<Category> storeAll(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(categoryRepository::deleteById);
    }
}
