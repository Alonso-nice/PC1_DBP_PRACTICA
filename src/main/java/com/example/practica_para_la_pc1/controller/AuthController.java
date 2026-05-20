package com.example.practica_para_la_pc1.controller;

import com.example.practica_para_la_pc1.DTO.Request.LoginRequestDTO;
import com.example.practica_para_la_pc1.DTO.Request.RegisterRequestDTO;
import com.example.practica_para_la_pc1.DTO.Response.LoginResponseDTO;
import com.example.practica_para_la_pc1.DTO.Response.RegisterResponseDTO;
import com.example.practica_para_la_pc1.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
