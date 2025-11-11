package com.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayDTO {

    private int idPay;

    @NotNull(message = "La fecha de pago no puede ser nula")
    private LocalDate datePay;

    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser mayor que cero")
    private Double amount;

    @NotNull(message = "El método de pago no puede ser nulo")
    @NotBlank(message = "El método de pago no puede estar vacío")
    @Size(min = 5, max = 20, message = "El método de pago debe tener entre 5 y 20 caracteres")
    @Pattern(
            regexp = "^(tarjeta|efectivo|transferencia)$",
            message = "El método de pago debe ser: tarjeta, efectivo o transferencia"
    )
    private String paymentMethod;

    @NotNull(message = "La factura asociada no puede ser nula")
    private BillDTO bill;
}
