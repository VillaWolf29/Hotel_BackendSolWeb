package com.hotel.service;

import com.hotel.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IGenericService <Customer,Integer> {
    Page<Customer> listPage(Pageable pageable);
}
