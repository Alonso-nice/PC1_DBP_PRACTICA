    package com.example.practica_para_la_pc1.controller;

    import com.example.practica_para_la_pc1.DTO.Request.ReservationRequestDTO;
    import com.example.practica_para_la_pc1.DTO.Response.ReservationResponseDTO;
    import com.example.practica_para_la_pc1.service.ReservationService;
    import org.springframework.security.core.Authentication;
    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/reservations")
    public class ReservationController {
        private final ReservationService reservationService;

        public ReservationController(ReservationService reservationService) {
            this.reservationService = reservationService;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public ReservationResponseDTO create(
                @RequestBody ReservationRequestDTO dto,
                Authentication authentication
        ) {
            String username = authentication.getName();
            return reservationService.create(dto, username);
        }
    }
