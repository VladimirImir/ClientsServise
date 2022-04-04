package com.example.clients_service;

import com.example.clients_service.repositories.ClientRepository;
import com.example.clients_service.services.data.ClientService;
import com.example.clients_service.services.data.qualifiers.ClientServiceQualifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientsServiceApplicationTests {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    @ClientServiceQualifier
    ClientService clientService;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(clientRepository);
        Assertions.assertNotNull(clientService, "SERVICE NULL!");
        //System.out.println(1/0);
    }

}
