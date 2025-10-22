package com.hotel.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Bill {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBill;

    @Column(nullable = false)
    private LocalDate dateEmission;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false, length = 20)
    private String paymentMethod; // tarjeta, efectivo, transferencia

    @Column(nullable = false, length = 20)
    private String state; // pagada, pendiente, anulada

    @ManyToOne
    @JoinColumn(name = "id_booking", nullable = false)
    private Booking booking;
}
