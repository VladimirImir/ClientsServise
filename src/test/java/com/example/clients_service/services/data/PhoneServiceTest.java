package com.example.clients_service.services.data;

import com.example.clients_service.models.Phone;
import com.example.clients_service.services.data.qualifiers.PhoneServiceQualifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PhoneServiceTest {
    @PhoneServiceQualifier
    @Autowired
    private PhoneService phoneService;

    @Test
    void saveAll(){
        List<Phone> phones = Arrays.asList(
                new Phone(0L, "+380981630055"),
                new Phone(0L, "+380981630011"),
                new Phone(0L, "+380981630099")
        );
        phoneService.saveAll(phones);
    }
}
