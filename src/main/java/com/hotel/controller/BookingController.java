package com.hotel.controller;

import com.hotel.model.Booking;
import com.hotel.model.Customer;
import com.hotel.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
//@AllArgsConstructor
@RequiredArgsConstructor
public class BookingController {

    private final IBookingService service;

    @GetMapping
    public List<Booking> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Booking findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Booking save(@RequestBody Booking booking) throws Exception{
        return service.save(booking);
    }

    @PutMapping("/{id}")
    public Booking update(@RequestBody Booking booking, @PathVariable("id") Integer id) throws Exception{
        return service.update(booking ,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
