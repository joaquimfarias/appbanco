package com.example.appbanco.repositories;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appbanco.domain.users.Users;

public interface UserRepository extends JpaRepository<Users , Long> {


    Optional<Users> findUserByDocument(String document);

    Optional<User> findUserById(Long id);
}
