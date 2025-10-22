package com.hotel.controller;

import com.hotel.model.Pay;
import com.hotel.service.IPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pays")
//@AllArgsConstructor
@RequiredArgsConstructor
public class PayController {
    private final IPayService service;

    @GetMapping
    public List<Pay> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pay findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Pay save(@RequestBody Pay pay) throws Exception{
        return service.save(pay);
    }

    @PutMapping("/{id}")
    public Pay update(@RequestBody Pay pay, @PathVariable("id") Integer id) throws Exception{
        return service.update(pay ,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }

}
