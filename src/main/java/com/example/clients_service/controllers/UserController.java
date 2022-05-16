package com.example.clients_service.controllers;

import com.example.clients_service.controllers.tools.BootstrapManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("users")
    public String load(Model model, @AuthenticationPrincipal Object ap) {
        BootstrapManager.setBootstrapHead(model);
        //info
        System.err.println("USERS: ");
        System.err.println(ap);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.err.println(auth.getAuthorities());
        //+
        return "users";
    }
}
