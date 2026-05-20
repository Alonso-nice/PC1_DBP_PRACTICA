package com.example.practica_para_la_pc1.exceptions;

public class UserNotFoundException
        extends RuntimeException {

    public UserNotFoundException(String username) {

        super("Usuario no encontrado: " + username);
    }
}