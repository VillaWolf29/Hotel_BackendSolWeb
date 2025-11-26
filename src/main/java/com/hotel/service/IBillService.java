package com.hotel.service;

import com.hotel.model.Bill;
import com.hotel.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBillService extends IGenericService<Bill,Integer>{
    Page<Bill> listPage(Pageable pageable);
}
