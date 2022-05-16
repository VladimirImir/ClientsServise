package com.example.clients_service.controllers;

import com.example.clients_service.controllers.tools.BootstrapManager;
import com.example.clients_service.models.User;
import com.example.clients_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("registration")
    public String load(Model model) {
        BootstrapManager.setBootstrapHead(model);
        //
        return "registration";
    }

    @PostMapping("register")
    public ModelAndView register(@RequestParam String login,
                                 @RequestParam String pass,
                                 @RequestParam String mail,
                                 ModelMap model) {
        User user = new User(0L, login, pass, mail, User.Status.ACTIVE,
                Collections.singleton(User.Role.USER));
        //info
        System.err.println("REGISTRATION find: " + userRepository.findByLogin(login));
        //seccess
        if (!userRepository.existsUserByLogin(login)){
            user = userRepository.save(user);
            System.err.println("REGISTRATION save: " + user);
            return new ModelAndView("redirect:registration");
        }
        //error
        else {
            model.addAttribute("message", login + " Already Exists!");
            return new ModelAndView("redirect:error", model);
        }

    }
}
