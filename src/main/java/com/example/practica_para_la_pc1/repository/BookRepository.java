package com.example.practica_para_la_pc1.repository;

import com.example.practica_para_la_pc1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByIsbn(String isbn);

    List<Book> findByAvailableCopiesGreaterThan(
            Integer copies
    );

    List<Book> findByAvailableCopies(
            Integer copies
    );
}
