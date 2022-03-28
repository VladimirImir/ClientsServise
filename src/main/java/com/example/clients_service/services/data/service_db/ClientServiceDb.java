package com.example.clients_service.services.data.service_db;

import com.example.clients_service.models.Client;
import com.example.clients_service.repositories.ClientRepository;
import com.example.clients_service.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceDb implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAllBySurnameAndNameAndPatronymic(String surname, String name, String patronymic) {
        return clientRepository.findAllBySurnameAndNameAndPatronymic(surname, name, patronymic);
    }

    @Override
    public Client save(Client client){
        return clientRepository.save(client);
    }
    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }


}
