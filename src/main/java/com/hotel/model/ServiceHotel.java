package com.hotel.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class ServiceHotel {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServiceHotel;

    @Column(nullable = false, length = 100)
    private String nameService; // spa, lavandería, restaurante, etc.

    @Column(nullable = false)
    private double price;

    @Column(length = 200)
    private String description;
}
