package com.example.clients_service.controllers;

import com.example.clients_service.controllers.tools.BootstrapManager;
import com.example.clients_service.models.Client;
import com.example.clients_service.models.Client.Gender;
import com.example.clients_service.services.data.ClientService;
import com.example.clients_service.services.data.qualifiers.ClientServiceQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {
    @ClientServiceQualifier
    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String main(Model model){
        BootstrapManager.setBootstrapHead(model);
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "main";
    }

    @GetMapping("main")
    public String main(){
        return "redirect:";
    }

    @PostMapping("add_client")
    public String addClient(Model model,
                            @RequestParam("surname")String surname,
                            @RequestParam("name")String name,
                            @RequestParam("patronymic")String patronymic,
                            @RequestParam("birthDate") String birthDate,
                            @RequestParam("email")String email,
                            @RequestParam("gender") Gender gender
                            ){
        System.err.println(LocalDate.parse(birthDate));
        System.err.println(gender);
        Client client = new Client(0L, surname, name, patronymic, LocalDate.parse(birthDate) , email, gender, null);
        clientService.save(client);
        return "redirect:/";
    }
}


