package com.hotel.dto;

import com.hotel.dto.BookingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillDTO {
    private int idBill;
    private LocalDate dateEmission;
    private double total;
    private String paymentMethod; // tarjeta, efectivo, transferencia
    private String state; // pagada, pendiente, anulada
    private BookingDTO booking;
}
