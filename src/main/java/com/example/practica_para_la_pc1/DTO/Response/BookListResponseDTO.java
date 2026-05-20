package com.example.practica_para_la_pc1.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookListResponseDTO {
    private List<BookResponseDTO> content ;
    private Integer page;
    private Integer size;
    private Integer totalPages;

}
