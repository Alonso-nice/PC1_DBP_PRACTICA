package com.example.practica_para_la_pc1.DTO.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDTO {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer totalCopies;
    private Integer availableCopies;
}
