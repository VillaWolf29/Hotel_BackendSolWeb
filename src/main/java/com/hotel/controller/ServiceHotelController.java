package com.hotel.controller;

import com.hotel.model.Customer;
import com.hotel.model.ServiceHotel;
import com.hotel.service.IServiceHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceshotel")
//@AllArgsConstructor
@RequiredArgsConstructor
public class ServiceHotelController {

    private final IServiceHotelService service;

    @GetMapping
    public List<ServiceHotel> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ServiceHotel findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public ServiceHotel save(@RequestBody ServiceHotel serviceHotel) throws Exception{
        return service.save(serviceHotel);
    }

    @PutMapping("/{id}")
    public ServiceHotel update(@RequestBody ServiceHotel serviceHotel, @PathVariable("id") Integer id) throws Exception{
        return service.update(serviceHotel ,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
