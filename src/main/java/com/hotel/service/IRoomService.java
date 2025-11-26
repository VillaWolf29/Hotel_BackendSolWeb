package com.hotel.service;
import com.hotel.model.Customer;
import com.hotel.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoomService extends IGenericService<Room, Integer> {
    Page<Room> listPage(Pageable pageable);
}
