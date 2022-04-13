package com.example.clients_service.controllers;

import com.example.clients_service.models.Phone;
import com.example.clients_service.services.data.PhoneService;
import com.example.clients_service.services.data.qualifiers.PhoneServiceQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PhoneController {
    @PhoneServiceQualifier
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/phone")
    public String phone(Model model){
        List<Phone> phones = phoneService.findAll();
        model.addAttribute("phones", phones);
        return "phone";
    }

    @PostMapping("add_phone")
    public String addPhone(Model model,
                           @RequestParam("phone") String phone){
        System.err.println(phone);
        Phone p1 = new Phone(0L, "+380981630055", null);
        phoneService.save(p1);
        return "redirect:/phone";
    }

}
