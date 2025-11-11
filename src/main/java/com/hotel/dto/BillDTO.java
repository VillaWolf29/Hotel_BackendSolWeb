package com.hotel.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillDTO {

    private int idBill;

    @NotNull(message = "La fecha de emisión no puede ser nula")
    private LocalDate dateEmission;

    @NotNull(message = "El total no puede ser nulo")
    @Positive(message = "El total debe ser mayor que cero")
    private Double total;

    @NotNull(message = "El método de pago no puede ser nulo")
    @NotBlank(message = "El método de pago no puede estar vacío")
    @Size(min = 5, max = 20, message = "El método de pago debe tener entre 5 y 20 caracteres")
    @Pattern(
            regexp = "^(tarjeta|efectivo|transferencia)$",
            message = "El método de pago debe ser: tarjeta, efectivo o transferencia"
    )
    private String paymentMethod; // tarjeta, efectivo, transferencia

    @NotNull(message = "El estado no puede ser nulo")
    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(
            regexp = "^(pagada|pendiente|anulada)$",
            message = "El estado debe ser: pagada, pendiente o anulada"
    )
    private String state; // pagada, pendiente, anulada

    @NotNull(message = "La reserva asociada no puede ser nula")
    private BookingDTO booking;
}
