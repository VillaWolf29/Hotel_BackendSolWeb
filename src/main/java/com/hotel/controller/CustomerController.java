package com.hotel.controller;

import com.hotel.model.Customer;
import com.hotel.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
//@AllArgsConstructor
@RequiredArgsConstructor

public class CustomerController {

    private final ICustomerService service;

    @GetMapping
    public List<Customer> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer) throws Exception{
        return service.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable("id") Integer id) throws Exception{
        return service.update(customer ,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
