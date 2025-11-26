package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.model.Pay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPayService extends  IGenericService<Pay, Integer> {
    Page<Pay> listPage(Pageable pageable);
}
