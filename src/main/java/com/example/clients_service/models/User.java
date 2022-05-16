package com.example.clients_service.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "users")
public class User {
    public enum Status{
        ACTIVE, BLOCKED, DELETED
    }
    public enum Role{
        ADMIN, USER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 32, unique = true)
    private String login;
    @Column(nullable = false, length = 32)
    private String pass;
    @Column(nullable = false, length = 64, unique = true)
    private String mail;
    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.ORDINAL)
    private Set<Role> role;

}
