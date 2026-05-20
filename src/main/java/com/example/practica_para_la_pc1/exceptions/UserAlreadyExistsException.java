package com.example.practica_para_la_pc1.exceptions;

public class UserAlreadyExistsException
        extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}