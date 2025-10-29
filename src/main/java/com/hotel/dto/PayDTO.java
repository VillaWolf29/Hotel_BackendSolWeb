package com.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayDTO {

    private int idPay;
    private LocalDate datePay;
    private double amount;
    private String paymentMethod;
    private BillDTO bill;
}
