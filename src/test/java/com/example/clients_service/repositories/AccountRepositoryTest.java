package com.example.clients_service.repositories;

import com.example.clients_service.models.Account;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //- Порядок выполнения методов.
//@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Order(1)//- Порядок выполнения методов.
    @Test
    void save(){
        Account a1 = new Account(0L, 5000);
        Account a2 = accountRepository.save(a1);
        Assertions.assertNotNull(a2);

    }

    // @Order(2) - Порядок выполнения методов.
    @Test
    void findAll(){
        List<Account> accounts = accountRepository.findAll();
        Assertions.assertNotEquals(accounts.size(),0);

    }
}
