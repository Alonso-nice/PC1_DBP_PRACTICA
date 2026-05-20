package com.example.practica_para_la_pc1.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoginResponseDTO {

    private String token;
    private Integer expiresIn;
}

