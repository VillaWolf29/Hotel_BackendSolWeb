package com.hotel.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDTO {

    private int idBooking;

    @NotNull(message = "La fecha de reserva no puede ser nula")
    private LocalDate dateBooking;

    @NotNull(message = "La fecha de check-in no puede ser nula")
    private LocalDate dateCheckIn;

    @NotNull(message = "La fecha de check-out no puede ser nula")
    private LocalDate dateCheckOut;

    @NotNull(message = "El estado de la reserva no puede ser nulo")
    @NotBlank(message = "El estado de la reserva no puede estar vacío")
    @Pattern(
            regexp = "^(reservado|checkin|checkout|cancelado)$",
            message = "El estado debe ser: reservado, checkin, checkout o cancelado"
    )
    private String state;

    @NotNull(message = "El cliente no puede ser nulo")
    private CustomerDTO customer;

    @NotNull(message = "La habitación no puede ser nula")
    private RoomDTO room;

    @NotNull(message = "El empleado no puede ser nulo")
    private EmployeeDTO employee;
}

