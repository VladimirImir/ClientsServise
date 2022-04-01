package com.example.clients_service.services.data.service_json;

import com.example.clients_service.models.Phone;
import com.example.clients_service.services.data.PhoneService;
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
public class PhoneServiceJson implements PhoneService {
    public final String FILE_NAME = "phones.json";
    @Override
    public List<Phone> findAllPhone(String phone) {
        return null;
    }

    @Override
    public Phone save(Phone phone) {
        List<Phone> phones = findAll();
        if (phones == null){
            phones = new ArrayList<>();
            phones.add(phone);
            Gson gson = new Gson();
            String json = gson.toJson(phones);
            try {
                FileUtils.write(new File(FILE_NAME), json, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return phone;
    }

    @Override
    public List<Phone> findAll() {
        Gson gson = new Gson();
        String json = null;
        try {
            json = FileUtils.readFileToString(new File(FILE_NAME), StandardCharsets.UTF_8);
            return gson.fromJson(json, new TypeToken<List<Phone>>(){}.getType());
        } catch (IOException e) {
            /* e.printStackTrace();*/
        }
        return null;
    }

}
