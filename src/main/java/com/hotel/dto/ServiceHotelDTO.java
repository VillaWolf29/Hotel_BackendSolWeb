package com.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceHotelDTO {

    private int idServiceHotel;

    @NotNull(message = "El nombre del servicio no puede ser nulo")
    @NotBlank(message = "El nombre del servicio no puede estar vacío")
    @Size(min = 3, max = 30, message = "El nombre del servicio debe tener entre 3 y 30 caracteres")
    @Pattern(
            regexp = "^(spa|lavandería|restaurante|gimnasio|bar|piscina|estacionamiento)$",
            message = "El servicio debe ser: spa, lavandería, restaurante, gimnasio, bar, piscina o estacionamiento"
    )
    private String nameService;

    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser mayor que cero")
    private Double price;

    @NotNull(message = "La descripción no puede ser nula")
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 10, max = 150, message = "La descripción debe tener entre 10 y 150 caracteres")
    private String description;
}
