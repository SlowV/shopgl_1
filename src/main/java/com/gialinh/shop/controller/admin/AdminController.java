package com.gialinh.shop.controller.admin;

import com.gialinh.shop.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_9:34 AM
 * @updatedAt 2/19/21_9:34 AM
 */
@Controller
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {
    private final AccountService accountService;

    @GetMapping
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/icons")
    public String icons() {
        return "admin/icons";
    }

    @GetMapping("/map")
    public String map() {
        return "admin/map";
    }

    @GetMapping("/maps")
    public String maps() {
        return "admin/maps";
    }

    @GetMapping("/notifications")
    public String notifications() {
        return "admin/notifications";
    }

    @GetMapping("/rtl")
    public String rtl() {
        return "admin/rtl";
    }

    @GetMapping("/tables")
    public String tables() {
        return "admin/tables";
    }

    @GetMapping("/typography")
    public String typography() {
        return "admin/typography";
    }

    @GetMapping("/upgrade")
    public String upgrade() {
        return "admin/upgrade";
    }

    @GetMapping("/user")
    public String user() {
        return "admin/user";
    }

    @GetMapping("/account/info")
    public String getAccountInfo(Principal principal, Model model) {
        model.addAttribute("accountInfo", accountService.findById(principal.getName()).getAccountInfo());
        return "admin/accountInfo";
    }
}
