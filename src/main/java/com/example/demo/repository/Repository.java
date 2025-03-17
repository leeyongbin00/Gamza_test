package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface Repository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
