package com.example.clients_service.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "clients")
public class Client {
    public enum Gender{
        NONE, MALE, FEMALE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String surname;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String patronymic;
    @Column
    private LocalDate birthDate;
    @Column(nullable = true, length = 50)
    private String email;
    @Column
    private Gender gender;


}
