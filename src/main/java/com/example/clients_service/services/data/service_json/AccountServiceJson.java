package com.example.clients_service.services.data.service_json;

import com.example.clients_service.models.Account;
import com.example.clients_service.services.data.AccountService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceJson implements AccountService {
    public final String FILE_NAME = "accounts.json";
    @Override
    public List<Account> findAllByAmount(Integer amount) {
        return null;
    }
    @Override
    public Account save(Account account) {
        List<Account> accounts = findAll();
        if (accounts == null){
            accounts = new ArrayList<>();
            accounts.add(account);
            Gson gson = new Gson();
            String json = gson.toJson(accounts);
            try {
                FileUtils.write(new File(FILE_NAME), json, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        Gson gson = new Gson();
        String json = null;
        try {
            json = FileUtils.readFileToString(new File(FILE_NAME), StandardCharsets.UTF_8);
            return gson.fromJson(json, new TypeToken<List<Account>>(){}.getType());
        } catch (IOException e) {
            /* e.printStackTrace();*/
        }
        return null;
    }

    @Override
    public List<Account> saveAll(List<Account> accounts) {
        return null;
    }

}
