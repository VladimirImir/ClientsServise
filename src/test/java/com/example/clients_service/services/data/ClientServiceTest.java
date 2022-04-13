package com.example.clients_service.services.data;

import com.example.clients_service.models.Account;
import com.example.clients_service.models.Client;
import com.example.clients_service.models.Phone;
import com.example.clients_service.repositories.PhoneRepository;
import com.example.clients_service.services.data.ClientService;
import com.example.clients_service.services.data.qualifiers.AccountServiceQualifier;
import com.example.clients_service.services.data.qualifiers.ClientServiceQualifier;
import com.example.clients_service.services.data.qualifiers.PhoneServiceQualifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;


@SpringBootTest
public class ClientServiceTest {
    @ClientServiceQualifier
    @Autowired
    private ClientService clientService;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    @AccountServiceQualifier
    private AccountService accountService;

    /*public static List<Client> generateClients(int count) {
        String surnames = "Сыпченко\n" +
                "Красинец\n" +
                "Тарасов\n" +
                "Несвитайло\n" +
                "Борисенко\n" +
                "Сасько\n" +
                "Ткаченко\n" +
                "Ефимов\n" +
                "Повалий\n" +
                "Дементьев";
        String names = "Тарас\n" +
                "Денис\n" +
                "Эдуард\n" +
                "Харитон\n" +
                "Йоханес\n" +
                "Аркадий\n" +
                "Клаус\n" +
                "Чеслав\n" +
                "Еремей\n" +
                "Кирилл";
        String patronymics = "Анатолиевич\n" +
                "Борисович\n" +
                "Петрович\n" +
                "Андреевич\n" +
                "Максимович\n" +
                "Алексеевич\n" +
                "Борисович\n" +
                "Станиславович\n" +
                "Романович\n" +
                "Платонович";
        //
        Random rd = new Random();
        String dl = "\n";
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            clients.add(new Client(
                    0L,
                    surnames.split(dl)[rd.nextInt(surnames.split(dl).length)],
                    names.split(dl)[rd.nextInt(names.split(dl).length)],
                    patronymics.split(dl)[rd.nextInt(patronymics.split(dl).length)],
                    "#@test.com".replace("#", "mail" + rd.nextInt(100)),
                    LocalDate.now(),
                    Client.Gender.NONE
            ));
        }
        return clients;
    }*/

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

    @Test
    void saveClientWithPhones() {
        Client client = new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                LocalDate.of(1998, 7, 11), "email222@gmail.com", Client.Gender.MALE);
        client = clientService.save(client);
        Phone p1 = new Phone(0L, "111", client);
        Phone p2 = new Phone(0L, "222", client);
        phoneRepository.saveAll(Arrays.asList(p1, p2));
    }

        @Test
        void saveClientsAccount(){
        /*List<Client> clients = new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                LocalDate.of(1998, 7, 11), "email222@gmail.com", Client.Gender.MALE);
        clients = clientService.saveAll(clients);*/

        /*List<Client> clients = generateClients(2);
        clients = clientService.saveAll(clients);*/

        List<Client> clients = Arrays.asList(
                new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                        LocalDate.of(1998, 7, 11), "email222@gmail.com", Client.Gender.MALE),
                new Client(0L, "Boba", "Vladimir", "Vladimirovich",
                        LocalDate.of(2000, 7, 11), "email999@gmail.com", Client.Gender.MALE)
        );
        List<Account> accounts = Arrays.asList(
                new Account(0L, 1000),
                new Account(0L, 1000)
        );
        accounts = accountService.saveAll(accounts);
        for (Client client : clients){
            for (Account account : accounts){
                if (client.getAccounts() == null)
                    client.setAccounts(new HashSet<>());
                if (account.getClients() == null)
                    account.setClients(new HashSet<>());
                client.getAccounts().add(account);
                account.getClients().add(client);
            }
        }
        // clients.forEach(client -> System.err.println(client + " " + client.getAccounts() ));
        clientService.saveAll(clients);
        //
        clients = clientService.findAll();
        clients.get(0).getAccounts().forEach(System.err::println);
    }
}
