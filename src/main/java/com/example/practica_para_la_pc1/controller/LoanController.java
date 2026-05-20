package com.example.practica_para_la_pc1.controller;

import com.example.practica_para_la_pc1.DTO.Request.LoanRequestDTO;
import com.example.practica_para_la_pc1.DTO.Response.LoanResponseDTO;
import com.example.practica_para_la_pc1.service.LoanService;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoanResponseDTO create(
            @RequestBody LoanRequestDTO dto,
            Authentication authentication
    ) {
        String username = authentication.getName();
        return loanService.create(dto, username);
    }
}
