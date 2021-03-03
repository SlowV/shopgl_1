package com.gialinh.shop.controller.admin;

import com.gialinh.shop.domain.Account;
import com.gialinh.shop.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

import static com.gialinh.shop.repository.spectification.AccountSpecification.email;

/**
 * @author SlowV
 * @createdAt 2/24/21_4:44 PM
 * @updatedAt 2/24/21_4:44 PM
 * @description
 */
@RequestMapping("/admin/employee")
@Controller
public class EmployeeController {
    private final AccountService accountService;

    public EmployeeController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String index(
            Model model,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "limit", defaultValue = "10", required = false) int limit,
            @RequestParam(value = "page", defaultValue = "1", required = false) int page
    ) {
        Specification<Account> specification = Specification.where(null);
        if (Objects.nonNull(email)) {
            specification = specification.and(email(email));
        }
        Page<Account> accounts = accountService.getAll(specification, page, limit);
        model.addAttribute("pageAccounts", accounts);
        return "admin/employee";
    }
}
