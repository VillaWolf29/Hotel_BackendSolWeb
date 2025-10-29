package com.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTO {

    private int idRoom;
    private int numRoom;
    private String type;
    private String ability;
    private double price;
    private boolean state;
}
