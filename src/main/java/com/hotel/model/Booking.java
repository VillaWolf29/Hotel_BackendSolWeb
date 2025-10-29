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
public class Booking {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBooking;

    @Column(nullable = false)
    private LocalDate dateBooking;

    @Column(nullable = false)
    private LocalDate dateCheckIn;

    @Column(nullable = false)
    private LocalDate dateCheckOut;

    @Column(nullable = false, length = 20)
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee employee;

}
