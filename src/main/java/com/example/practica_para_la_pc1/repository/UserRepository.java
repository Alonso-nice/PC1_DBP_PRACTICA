package com.example.practica_para_la_pc1.repository;

import com.example.practica_para_la_pc1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);//¿Existe un usuario con este username?

    boolean existsByEmail(String email);//¿Existe un usuario con este email?

    Optional<User> findByUsername(String username);//bucsa usuario completo
}
