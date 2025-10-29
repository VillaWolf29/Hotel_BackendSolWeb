package com.hotel.controller;

import com.hotel.model.Customer;
import com.hotel.dto.CustomerDTO;
import com.hotel.service.ICustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
//@AllArgsConstructor
@RequiredArgsConstructor

public class CustomerController {

    private final ICustomerService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() throws Exception {
        //List<CustomerDTO> list = service.findAll().stream().map(e -> new CustomerDTO(e.getIdCustomer(),e.getFirstName(), e.getLastName(), e.getPhone(), e.getEmail(), e.getDni(), e.getAddress())).toList();
        //ModelMapper modelMapper = new ModelMapper();
        //List<CustomerDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, CustomerDTO.class)).toList();
        List<CustomerDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable("id") Integer id) throws Exception {
        //Customer obj =  service.findById(id);
        //CustomerDTO obj = modelMapper.map(service.findById(id), CustomerDTO.class);
        CustomerDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Customer> save(@Valid @RequestBody CustomerDTO dto) throws Exception {
        //Customer obj =  service.save(customer);
        //return ResponseEntity.ok(obj);
        // localhost:8080/customers/{id}
        //Customer obj = service.save(modelMapper.map(dto, Customer.class));
        Customer obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdCustomer()).toUri();
        return ResponseEntity.created(location).build();
        //return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CustomerDTO dto) throws Exception {
        //Customer obj = service.update(customer, id);
        // Customer obj = service.update(modelMapper.map(dto, Customer.class), id);
        Customer obj = service.update(convertToEntity(dto), id);
        //CustomerDTO dto1 = modelMapper.map(obj, CustomerDTO.class );
        CustomerDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CustomerDTO convertToDto(Customer obj) {
        return modelMapper.map(obj, CustomerDTO.class);
    }

    private Customer convertToEntity(CustomerDTO dto) {
        return modelMapper.map(dto, Customer.class);
    }
}
