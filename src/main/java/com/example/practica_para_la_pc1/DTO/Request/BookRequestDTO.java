package com.example.practica_para_la_pc1.DTO.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {

    @NotBlank(message = "El title es obligatorio " )
    private String title;

    @NotBlank(message = "El autor es obligatorio")//solo para string
    private String author;

    private String isbn;


    @Min(0)
    private Integer totalCopies;

    @NotBlank(message = "El available es obligatorio ")
    private String availableCopies;

}
