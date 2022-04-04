package com.example.clients_service.repositories;

import com.example.clients_service.models.Phone;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //- Порядок выполнения методов.
//@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class PhoneRepositoryTest {
    @Autowired
    PhoneRepository phoneRepository;

    @Order(1)//- Порядок выполнения методов.
    @Test
    void save(){
        Phone p1 = new Phone(0L, "+380981122333");
        Phone p2 = phoneRepository.save(p1);
        Assertions.assertNotNull(p2);

    }

    // @Order(2) - Порядок выполнения методов.
    @Test
    void findAll(){
        List<Phone> phones = phoneRepository.findAll();
        Assertions.assertNotEquals(phones.size(),0);

    }

}
