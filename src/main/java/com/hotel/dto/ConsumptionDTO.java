package com.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConsumptionDTO {

    private int idConsumption;
    private int amount;
    private LocalDate dateConsumption ;
    private double subtotal;
    private BookingDTO  booking;
    private ServiceHotelDTO  serviceHotel;
}
