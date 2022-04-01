package com.example.clients_service.services.data.service_db;

import com.example.clients_service.models.Phone;
import com.example.clients_service.repositories.PhoneRepository;
import com.example.clients_service.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceDb implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAllPhone(String phone) {
        return  phoneRepository.findAllByPhone(phone);
    }

    @Override
    public Phone save(Phone phone){
        return phoneRepository.save(phone);
    }
    @Override
    public List<Phone> findAll(){
        return phoneRepository.findAll();
    }
}
