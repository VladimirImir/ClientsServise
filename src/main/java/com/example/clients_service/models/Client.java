package com.example.clients_service.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Phone> phones;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "clients_accounts",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id")
    )
    private Set<Account> accounts;

    public Client(Long id, String surname, String name,
                  String patronymic, LocalDate birthDate, String email, Gender gender) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
    }

    public Client(Long id, String surname, String name, String patronymic,
                  LocalDate birthDate, String email, Gender gender, Set<Phone> phones) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
        this.phones = phones;
    }

    /**Constructor*/





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(surname, client.surname)
                && Objects.equals(name, client.name)
                && Objects.equals(patronymic, client.patronymic)
                && Objects.equals(birthDate, client.birthDate)
                && Objects.equals(email, client.email)
                && gender == client.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, birthDate, email, gender);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
