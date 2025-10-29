package com.hotel.controller;

import com.hotel.model.Customer;
import com.hotel.model.Employee;
import com.hotel.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
//@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService service;

    @GetMapping
    public List<Employee> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) throws Exception{
        return service.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable("id") Integer id) throws Exception{
        return service.update(employee ,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
