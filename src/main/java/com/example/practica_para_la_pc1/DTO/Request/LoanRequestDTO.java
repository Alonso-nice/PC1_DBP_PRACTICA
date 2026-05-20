package com.example.practica_para_la_pc1.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequestDTO {

    private Long bookId;

    private LocalDate borrowDate;
}
