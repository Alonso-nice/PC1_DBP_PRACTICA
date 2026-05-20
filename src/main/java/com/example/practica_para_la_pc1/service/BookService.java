package com.example.practica_para_la_pc1.service;

import com.example.practica_para_la_pc1.DTO.Request.BookRequestDTO;
import com.example.practica_para_la_pc1.DTO.Response.BookResponseDTO;
import com.example.practica_para_la_pc1.entity.Book;
import com.example.practica_para_la_pc1.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // CREAR LIBRO
    public BookResponseDTO createBook(
            BookRequestDTO dto) {

        // validar ISBN único
        if(dto.getIsbn() != null &&
                bookRepository.existsByIsbn(dto.getIsbn())) {

            throw new RuntimeException(
                    "ISBN ya existe"
            );
        }

        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .totalCopies(dto.getTotalCopies())
                .availableCopies(
                        dto.getTotalCopies()
                )
                .build();

        Book savedBook =
                bookRepository.save(book);

        return toResponse(savedBook);
    }

    // LISTAR LIBROS
    public List<BookResponseDTO> getBooks(
            String status) {

        List<Book> books;

        if(status.equals("available")) {

            books = bookRepository
                    .findByAvailableCopiesGreaterThan(0);

        } else if(status.equals("unavailable")) {

            books = bookRepository
                    .findByAvailableCopies(0);

        } else {

            books = bookRepository.findAll();
        }

        return books.stream()
                .map(this::toResponse)
                .toList();
    }

    // BUSCAR POR ID
    public Book findById(Long id) {

        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Libro no encontrado"
                        )
                );
    }

    // ENTITY -> DTO
    private BookResponseDTO toResponse(
            Book book) {

        return BookResponseDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .totalCopies(
                        book.getTotalCopies()
                )
                .availableCopies(
                        book.getAvailableCopies()
                )
                .build();
    }

}
