package com.example.practica_para_la_pc1.service;

import com.example.practica_para_la_pc1.DTO.Request.LoanRequestDTO;
import com.example.practica_para_la_pc1.DTO.Response.LoanResponseDTO;
import com.example.practica_para_la_pc1.entity.Book;
import com.example.practica_para_la_pc1.entity.Loan;
import com.example.practica_para_la_pc1.entity.User;
import com.example.practica_para_la_pc1.exceptions.BookNotFoundException;
import com.example.practica_para_la_pc1.exceptions.NoCopiesAvailableException;
import com.example.practica_para_la_pc1.exceptions.UserNotFoundException;
import com.example.practica_para_la_pc1.repository.BookRepository;
import com.example.practica_para_la_pc1.repository.LoanRepository;
import com.example.practica_para_la_pc1.repository.UserRepository;
import com.example.practica_para_la_pc1.exceptions.OverdueLoanException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.time.LocalDate;

@Service
@Transactional
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LoanService(
            LoanRepository loanRepository,
            BookRepository bookRepository,
            UserRepository userRepository
    ) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public LoanResponseDTO create(
            LoanRequestDTO request,
            String username
    ) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UserNotFoundException(username));

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() ->
                        new BookNotFoundException("Libro no encontrado: " + request.getBookId())
                );

        if (book.getAvailableCopies() <= 0) {
            throw new NoCopiesAvailableException("No hay copias disponibles del libro: " + book.getId());
        }

        boolean hasOverdue =
                loanRepository
                        .existsByUserIdAndStatusAndDueDateBefore(
                                user.getId(),
                                "ACTIVE",
                                LocalDate.now()
                        );

        if (hasOverdue) {
            throw new OverdueLoanException("El usuario tiene préstamos vencidos");
        }

        LocalDate borrowDate =
                request.getBorrowDate() != null
                        ? request.getBorrowDate()
                        : LocalDate.now();

        LocalDate dueDate =
                borrowDate.plusDays(14);

        book.setAvailableCopies(
                book.getAvailableCopies() - 1
        );

        bookRepository.save(book);

        Loan loan = Loan.builder()
                .bookId(book.getId())
                .userId(user.getId())
                .borrowDate(borrowDate)
                .dueDate(dueDate)
                .status("ACTIVE")
                .build();

        Loan saved = loanRepository.save(loan);

        return LoanResponseDTO.builder()
                .id(saved.getId())
                .bookId(saved.getBookId())
                .userId(user.getId())
                .borrowName(user.getUsername())
                .borrowDate(saved.getBorrowDate())
                .dueDate(saved.getDueDate())
                .status(saved.getStatus())
                .build();
    }
}