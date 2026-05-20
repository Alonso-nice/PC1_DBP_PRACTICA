package com.example.practica_para_la_pc1.service;

import com.example.practica_para_la_pc1.DTO.Request.ReservationRequestDTO;
import com.example.practica_para_la_pc1.DTO.Response.ReservationResponseDTO;
import com.example.practica_para_la_pc1.entity.Book;
import com.example.practica_para_la_pc1.entity.Reservation;
import com.example.practica_para_la_pc1.entity.User;
import com.example.practica_para_la_pc1.repository.BookRepository;
import com.example.practica_para_la_pc1.repository.ReservationRepository;
import com.example.practica_para_la_pc1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    public ReservationResponseDTO create(
            ReservationRequestDTO dto,
            String username
    ) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        if (book.getAvailableCopies() > 0) {
            throw new RuntimeException("Solo se puede reservar si no hay copias disponibles");
        }

        ZonedDateTime now = ZonedDateTime.now();

        Reservation reservation = Reservation.builder()
                .bookId(book.getId())
                .userId(user.getId())
                .reservedAt(now)
                .expiresAt(now.plusHours(48))
                .status("PENDING")
                .build();

        Reservation saved = reservationRepository.save(reservation);

        ReservationResponseDTO response = new ReservationResponseDTO();
        response.setId(saved.getId());
        response.setBookId(saved.getBookId());
        response.setUserId(saved.getUserId());
        response.setStatus(saved.getStatus());

        return response;
    }
}
