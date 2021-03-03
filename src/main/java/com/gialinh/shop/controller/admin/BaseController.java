package com.gialinh.shop.controller.admin;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author SlowV
 * @createdAt 3/3/21_9:50 AM
 * @updatedAt 3/3/21_9:50 AM
 * @description
 */
public interface BaseController<T, K> {
    String index(Model model, int limit, int page);

    String add(RedirectAttributes redirectAttributes, List<T> ts);

    String update(RedirectAttributes redirectAttributes, T t);

    boolean delete(List<K> ids);

    T show(K id);
}
