package com.gialinh.shop.domain.dto;

import com.gialinh.shop.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author SlowV
 * @createdAt 3/3/21_1:53 PM
 * @updatedAt 3/3/21_1:53 PM
 * @description
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriesCreationDto {
    private List<Category> categories;

    public void addCategory(Category category) {
        this.categories.add(category);
    }
}
