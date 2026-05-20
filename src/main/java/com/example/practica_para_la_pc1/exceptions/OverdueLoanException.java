package com.example.practica_para_la_pc1.exceptions;

public class OverdueLoanException
        extends RuntimeException {

    public OverdueLoanException(String message) {
        super(message);
    }
}