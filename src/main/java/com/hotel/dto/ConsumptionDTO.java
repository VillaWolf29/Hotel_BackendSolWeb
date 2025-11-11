package com.hotel.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsumptionDTO {

    private int idConsumption;

    @NotNull(message = "La cantidad no puede ser nula")
    @Positive(message = "La cantidad debe ser mayor que cero")
    private Integer amount;

    @NotNull(message = "La fecha de consumo no puede ser nula")
    private LocalDate dateConsumption;

    @NotNull(message = "El subtotal no puede ser nulo")
    @PositiveOrZero(message = "El subtotal no puede ser negativo")
    private Double subtotal;

    @NotNull(message = "La reserva asociada no puede ser nula")
    private BookingDTO booking;

    @NotNull(message = "El servicio del hotel no puede ser nulo")
    private ServiceHotelDTO serviceHotel;
}

