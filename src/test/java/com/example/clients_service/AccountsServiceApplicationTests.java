package com.example.clients_service;

import com.example.clients_service.repositories.AccountRepository;
import com.example.clients_service.repositories.ClientRepository;
import com.example.clients_service.services.data.AccountService;
import com.example.clients_service.services.data.ClientService;
import com.example.clients_service.services.data.qualifiers.AccountServiceQualifier;
import com.example.clients_service.services.data.qualifiers.ClientServiceQualifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountsServiceApplicationTests {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    @AccountServiceQualifier
    AccountService accountService;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(accountRepository);
        Assertions.assertNotNull(accountService, "SERVICE NULL!");
        //System.out.println(1/0);
    }
}
