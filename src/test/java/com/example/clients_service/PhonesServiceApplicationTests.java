package com.example.clients_service;

import com.example.clients_service.repositories.AccountRepository;
import com.example.clients_service.repositories.PhoneRepository;
import com.example.clients_service.services.data.AccountService;
import com.example.clients_service.services.data.PhoneService;
import com.example.clients_service.services.data.qualifiers.AccountServiceQualifier;
import com.example.clients_service.services.data.qualifiers.PhoneServiceQualifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhonesServiceApplicationTests {
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    @PhoneServiceQualifier
    PhoneService phoneService;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(phoneRepository);
        Assertions.assertNotNull(phoneService, "SERVICE NULL!");
        //System.out.println(1/0);
    }
}
