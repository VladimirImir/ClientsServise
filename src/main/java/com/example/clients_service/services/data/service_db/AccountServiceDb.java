package com.example.clients_service.services.data.service_db;

import com.example.clients_service.models.Account;
import com.example.clients_service.repositories.AccountRepository;
import com.example.clients_service.services.data.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDb implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAllByAmount(Integer amount) {
        return accountRepository.findAllByAmount(amount);
    }
    @Override
    public Account save(Account account){
        return accountRepository.save(account);
    }
    @Override
    public List<Account> findAll(){
        return accountRepository.findAll();
    }
    @Override
    public List<Account> saveAll(List<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }



}
