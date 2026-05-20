package com.example.practica_para_la_pc1.DTO.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponseDTO {

    private Long id;
    private Long bookId;
    private Long userId;
    private String borrowName;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private String status;
}
