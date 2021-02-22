package com.gialinh.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/19/21_9:34 AM
 * @updatedAt 2/19/21_9:34 AM
 */
@Controller
@RequestMapping(value = "/admin")

public class AdminController {

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

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
}
