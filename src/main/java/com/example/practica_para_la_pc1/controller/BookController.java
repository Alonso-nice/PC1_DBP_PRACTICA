package com.example.practica_para_la_pc1.controller;

import com.example.practica_para_la_pc1.DTO.Request.BookRequestDTO;
import com.example.practica_para_la_pc1.DTO.Response.BookResponseDTO;
import com.example.practica_para_la_pc1.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDTO create(@RequestBody BookRequestDTO dto) {
        return bookService.createBook(dto);
    }

    @GetMapping
    public List<BookResponseDTO> getAll(
            @RequestParam(defaultValue = "all") String status
    ) {
        return bookService.getBooks(status);
    }
}
