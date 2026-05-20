package com.example.practica_para_la_pc1.exceptions;

public class BookNotFoundException
        extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}