package com.example.clients_service.repositories;

import com.example.clients_service.models.Client;
import com.example.clients_service.models.Client.Gender;
import com.example.clients_service.models.Phone;
import com.example.clients_service.services.data.ClientService;
import com.example.clients_service.services.data.PhoneService;
import com.example.clients_service.services.data.qualifiers.ClientServiceQualifier;
import com.example.clients_service.services.data.qualifiers.PhoneServiceQualifier;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //- Порядок выполнения методов.
//@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    @ClientServiceQualifier
    ClientService clientService;
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    @PhoneServiceQualifier
    PhoneService phoneService;

    @Order(1)//- Порядок выполнения методов.
    @Test
    void save() {
        Client c1 = new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                LocalDate.of(1997, 7, 7), "email222@gmail.com", Gender.MALE, null);
        Client c2 = clientRepository.save(c1);
        Assertions.assertNotNull(c2);

        Client client = new Client(0L, "AA", "N1", "C1",
                LocalDate.of(1956, 02, 15), "a@a", Client.Gender.MALE, null);
        client = clientService.save(client);
        /*phoneService.deleteAll();*/
        Phone p1 = new Phone(0L, "111", client);
        Phone p2 = new Phone(0L, "222", client);
        Phone p3 = new Phone(0L, "333", client);
        phoneRepository.saveAll(Arrays.asList(p1, p2, p3));

    }

    // @Order(2) - Порядок выполнения методов.
    @Test
    void findAll() {
        List<Client> clients = clientRepository.findAll();
        Assertions.assertNotEquals(clients.size(), 0);

    }
}
