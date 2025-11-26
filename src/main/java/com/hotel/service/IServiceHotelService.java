package com.hotel.service;
import com.hotel.model.Customer;
import com.hotel.model.ServiceHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceHotelService extends IGenericService<ServiceHotel,Integer>{
    Page<ServiceHotel> listPage(Pageable pageable);
}

