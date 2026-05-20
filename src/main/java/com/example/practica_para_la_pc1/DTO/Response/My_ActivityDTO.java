package com.example.practica_para_la_pc1.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class My_ActivityDTO {

    private String type;
    private Long id;
    private Long book_id;
    private String bookTitle;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private String status;
    private ZonedDateTime reserveAt;
    private ZonedDateTime expiresAt;
}
