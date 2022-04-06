package com.example.clients_service.services.data;

import com.example.clients_service.models.Client;
import com.example.clients_service.services.data.ClientService;
import com.example.clients_service.services.data.qualifiers.ClientServiceQualifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class ClientServiceTest {
    @ClientServiceQualifier
    @Autowired
    private ClientService clientService;

    @Test
    void saveAll() {
        List<Client> clients = Arrays.asList(
                new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                        LocalDate.of(1998, 7, 11), "email222@gmail.com", Client.Gender.MALE),
                new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                        LocalDate.of(1992, 6, 18), "email222@gmail.com", Client.Gender.MALE),
                new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                        LocalDate.of(1997, 1, 22), "email222@gmail.com", Client.Gender.MALE)
        );
        clientService.saveAll(clients);
    }
}
