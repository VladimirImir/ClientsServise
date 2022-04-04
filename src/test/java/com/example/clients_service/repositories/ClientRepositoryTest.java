package com.example.clients_service.repositories;

import com.example.clients_service.models.Client;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //- Порядок выполнения методов.
//@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;

    @Order(1)//- Порядок выполнения методов.
    @Test
    void save(){
        Client c1 = new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                LocalDate.of(1997, 7, 7), "email222@gmail.com");
        Client c2 = clientRepository.save(c1);
        Assertions.assertNotNull(c2);

    }

    // @Order(2) - Порядок выполнения методов.
    @Test
    void findAll(){
        List<Client> clients = clientRepository.findAll();
        Assertions.assertNotEquals(clients.size(),0);

    }
}
