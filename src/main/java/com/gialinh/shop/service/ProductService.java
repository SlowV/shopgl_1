package com.gialinh.shop.service;

/**
 * @author SlowV
 * @createdAt 3/2/21_1:24 PM
 * @updatedAt 3/2/21_1:24 PM
 * @description
 */

import com.gialinh.shop.domain.Product;
import com.gialinh.shop.domain.enumeration.Status;
import com.gialinh.shop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.gialinh.shop.repository.spectification.AccountSpecification.CREATED_DATE;

@Service
@AllArgsConstructor
public class ProductService implements IService<Product, Long> {
    private final ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Specification<Product> specification, int page, int limit) {
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_DATE);
        Pageable pageable = PageRequest.of(page - 1, limit, sort);
        return productRepository.findAll(specification, pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product store(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> storeAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(productRepository::deleteById);
    }
}
