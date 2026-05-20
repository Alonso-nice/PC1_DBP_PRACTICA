package com.example.practica_para_la_pc1.exceptions;

public class NoCopiesAvailableException
        extends RuntimeException {

    public NoCopiesAvailableException(String message) {
        super(message);
    }
}