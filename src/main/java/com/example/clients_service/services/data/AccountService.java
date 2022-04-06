package com.example.clients_service.services.data;

import com.example.clients_service.models.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> findAllByAmount(Integer amount);

    Account save(Account account);

    List<Account> findAll();

    List<Account> saveAll(List<Account> accounts);

}
