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
public class Pay {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPay;

    @Column(nullable = false)
    private LocalDate datePay;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false, length = 20)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn( nullable = false)
    private Bill bill;

}
