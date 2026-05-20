package com.example.practica_para_la_pc1.repository;

import com.example.practica_para_la_pc1.DTO.Request.LoanRequestDTO;
import com.example.practica_para_la_pc1.DTO.Response.LoanResponseDTO;
import com.example.practica_para_la_pc1.entity.Loan;
import com.example.practica_para_la_pc1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);

    boolean existsByUserIdAndStatusAndDueDateBefore(
            Long userId,
            String status,
            LocalDate date
    );
}

