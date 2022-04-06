package com.example.clients_service.controllers;

import com.example.clients_service.models.Account;
import com.example.clients_service.services.data.AccountService;
import com.example.clients_service.services.data.qualifiers.AccountServiceQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AccountController {
    @AccountServiceQualifier
    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public String account(Model model){
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "account";
    }

    @PostMapping("add_account")
    public String addAccount(Model model,
                             @RequestParam("amount") Integer amount){
        System.err.println(amount);
        Account a1 = new Account(0L, 8500);
        accountService.save(a1);
        return "redirect:/account";
    }
}
