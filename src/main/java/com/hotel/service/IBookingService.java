package com.hotel.service;
import com.hotel.model.Booking;
import com.hotel.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookingService extends IGenericService<Booking,Integer> {
    Page<Booking> listPage(Pageable pageable);
}
