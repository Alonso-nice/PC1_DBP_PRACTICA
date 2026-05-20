package com.example.practica_para_la_pc1.exceptions;

public class LoanNotFoundException
        extends RuntimeException {

    public LoanNotFoundException(String message) {
        super(message);
    }
}