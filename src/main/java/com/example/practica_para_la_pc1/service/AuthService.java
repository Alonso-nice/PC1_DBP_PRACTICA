package com.example.practica_para_la_pc1.service;

import com.example.practica_para_la_pc1.DTO.Request.LoginRequestDTO;
import com.example.practica_para_la_pc1.DTO.Request.RegisterRequestDTO;
import com.example.practica_para_la_pc1.DTO.Response.LoginResponseDTO;
import com.example.practica_para_la_pc1.DTO.Response.RegisterResponseDTO;
import com.example.practica_para_la_pc1.entity.User;
import com.example.practica_para_la_pc1.repository.UserRepository;
import com.example.practica_para_la_pc1.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public RegisterResponseDTO register(RegisterRequestDTO dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username ya existe");
        }
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email ya existe");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(user);

        return new RegisterResponseDTO(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }

    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        boolean matches = passwordEncoder.matches(dto.getPassword(), user.getPassword());
        if (!matches) {
            throw new RuntimeException("Password incorrecto");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new LoginResponseDTO(token, 3600);
    }
}