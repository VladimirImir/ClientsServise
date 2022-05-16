package com.example.clients_service.controllers;

import com.example.clients_service.controllers.tools.BootstrapManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
    @GetMapping("error")
    public String load(Model model, @ModelAttribute("message") String message){
        BootstrapManager.setBootstrapHead(model);
        // info.
        System.err.println("ERROR: " + message);
        //
        return "error";
    }
}
