package com.hotel.service;

import com.hotel.model.Consumption;
import com.hotel.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IConsumptionService extends IGenericService<Consumption,Integer> {
    Page<Consumption> listPage(Pageable pageable);
}
