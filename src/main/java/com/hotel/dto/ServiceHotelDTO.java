package com.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceHotelDTO {

    private int idService;
    private String nameService; // spa, lavandería, restaurante, etc.
    private double price;
    private String description;
}
