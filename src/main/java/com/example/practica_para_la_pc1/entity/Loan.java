package com.example.practica_para_la_pc1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private Long userId;

    @Builder.Default
    private LocalDate borrowDate= LocalDate.now();//esto hace que la fecha sea hoy por defecto

    @Builder.Default
    private LocalDate dueDate= LocalDate.now().plusDays(14);


    @Builder.Default
    private String status="ACTIVE";
}
