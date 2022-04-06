package com.example.clients_service.services.data;

import com.example.clients_service.models.Account;
import com.example.clients_service.services.data.qualifiers.AccountServiceQualifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class AccountServiceTest {
    @AccountServiceQualifier
    @Autowired

    private AccountService accountService;

    @Test
    void saveAll(){
        List<Account> accounts = Arrays.asList(
                new Account(0L, 7500),
                new Account(0L, 7500),
                new Account(0L, 7500)
                );
        accountService.saveAll(accounts);
    }
}
