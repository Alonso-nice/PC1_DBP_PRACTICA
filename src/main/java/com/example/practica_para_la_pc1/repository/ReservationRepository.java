package com.example.practica_para_la_pc1.repository;

import com.example.practica_para_la_pc1.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
