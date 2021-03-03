package com.gialinh.shop.controller.admin;

import com.gialinh.shop.domain.Category;
import com.gialinh.shop.domain.Product;
import com.gialinh.shop.service.CategoryService;
import com.gialinh.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author SlowV
 * @createdAt 3/2/21_1:22 PM
 * @updatedAt 3/2/21_1:22 PM
 * @description
 */
@Controller
@RequestMapping(value = "/admin/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public String index(
            Model model,
            @RequestParam(value = "limit", defaultValue = "10", required = false) int limit,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.categoriesNonFilter());
        Specification<Product> specification = Specification.where(null);
        model.addAttribute("products", productService.getAll(specification, page, limit));
        return "/admin/product";
    }

    @PostMapping
    public String add(
            RedirectAttributes redirectAttributes,
            @ModelAttribute Product product,
            @RequestParam(value = "action", defaultValue = "add", required = false) String action) {
        productService.store(product);
        if ("add".equals(action)) {
            redirectAttributes.addFlashAttribute("msg", "Thêm sản phẩm thành công!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Sửa sản phẩm thành công!");
        }
        return "redirect:/admin/product";
    }

    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam List<Long> ids) {
        productService.delete(ids);
        return true;
    }

}
