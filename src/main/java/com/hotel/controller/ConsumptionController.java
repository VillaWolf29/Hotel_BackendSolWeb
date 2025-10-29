package com.hotel.controller;

import com.hotel.model.Consumption;
import com.hotel.model.Customer;
import com.hotel.service.IConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumptions")
//@AllArgsConstructor
@RequiredArgsConstructor
public class ConsumptionController {

    private final IConsumptionService service;

    @GetMapping
    public List<Consumption> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Consumption findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Consumption save(@RequestBody Consumption consumption) throws Exception{
        return service.save(consumption);
    }

    @PutMapping("/{id}")
    public Consumption update(@RequestBody Consumption consumption, @PathVariable("id") Integer id) throws Exception{
        return service.update(consumption ,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
