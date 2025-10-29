package com.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private int idCustomer;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String idCard;
    private String address;

}
