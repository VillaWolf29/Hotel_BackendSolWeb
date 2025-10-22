package com.hotel.controller;


import com.hotel.service.IBillService;
import com.hotel.model.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final IBillService service;

    @GetMapping
    public List<Bill> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Bill findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Bill save(@RequestBody Bill bill) throws Exception{
        return service.save(bill);
    }

    @PutMapping("/{id}")
    public Bill update(@RequestBody Bill bill, @PathVariable("id") Integer id) throws Exception{
        return service.update(bill ,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }


}
