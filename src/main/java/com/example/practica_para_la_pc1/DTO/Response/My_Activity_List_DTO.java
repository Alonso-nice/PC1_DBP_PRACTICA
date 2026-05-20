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
public class My_Activity_List_DTO {
    private List<My_ActivityDTO> content;
    private Integer page;

    private Integer size;

    private Long totalElements;
}
