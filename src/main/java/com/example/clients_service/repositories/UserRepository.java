package com.example.clients_service.repositories;

import com.example.clients_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    boolean existsUserByLogin(String login);
}
