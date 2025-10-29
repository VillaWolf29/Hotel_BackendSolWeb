package com.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDTO {

    private int idBooking;
    private LocalDate dateBooking;
    private LocalDate dateCheckIn;
    private LocalDate dateCheckOut;
    private String state;
    private CustomerDTO customer;
    private RoomDTO  room;
    private EmployeeDTO employee;
}
