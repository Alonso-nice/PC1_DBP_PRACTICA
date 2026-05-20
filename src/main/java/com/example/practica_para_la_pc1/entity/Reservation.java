package com.example.practica_para_la_pc1.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.ZonedDateTime;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private Long userId;

    @Builder.Default
    private ZonedDateTime reservedAt=ZonedDateTime.now();

    @Builder.Default
    private ZonedDateTime expiresAt =
            ZonedDateTime.now().plusHours(48);

    @Column(nullable = false)
    @Builder.Default
    private String status = "PENDING";

}
