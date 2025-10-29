package com.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private int idEmpleado;
    private String firstName;
    private String lastName;
    private String post;
    private String phone;
    private String email;

}
