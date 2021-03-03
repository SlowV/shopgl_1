package com.gialinh.shop.controller.admin;

import com.gialinh.shop.domain.Category;
import com.gialinh.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * @author SlowV
 * @createdAt 3/2/21_5:21 PM
 * @updatedAt 3/2/21_5:21 PM
 * @description
 */
@Controller
@RequestMapping("/admin/category")
@AllArgsConstructor
public class CategoryController implements BaseController<Category, Long> {
    private final CategoryService categoryService;

    @Override
    @GetMapping
    public String index(
            Model model,
            @RequestParam(value = "limit", defaultValue = "10", required = false) int limit,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page
    ) {
        Specification<Category> specification = Specification.where(null);
        model.addAttribute("categories", categoryService.getAll(specification, page, limit));
        model.addAttribute("category", new Category());
        return "/admin/category";
    }

    @Override
    @PostMapping
    public String add(
            RedirectAttributes redirectAttributes,
            @ModelAttribute List<Category> categories) {
        categoryService.storeAll(categories);
        redirectAttributes.addFlashAttribute("msg", "Thêm danh mục thành công!");
        return "redirect:/admin/category";
    }


    @Override
    @PostMapping("/update")
    public String update(
            RedirectAttributes redirectAttributes,
            @ModelAttribute Category category) {
        categoryService.store(category);
        redirectAttributes.addFlashAttribute("msg", "Cập nhật danh mục thành công!");
        return "redirect:/admin/category";
    }

    @Override
    @DeleteMapping
    @ResponseBody
    public boolean delete(List<Long> ids) {
        categoryService.delete(ids);
        return true;
    }

    @Override
    @GetMapping("/{id}")
    @ResponseBody
    public Category show(@PathVariable Long id) {
        return categoryService.findById(id);
    }
}
