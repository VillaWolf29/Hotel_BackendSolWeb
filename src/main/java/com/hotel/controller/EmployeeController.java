package com.hotel.controller;

import com.hotel.dto.EmployeeDTO;
import com.hotel.model.Customer;
import com.hotel.model.Employee;
import com.hotel.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
//@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() throws Exception{
        List<EmployeeDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable("id") Integer id) throws Exception{
        EmployeeDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Employee>  save(@Valid @RequestBody EmployeeDTO dto) throws Exception{
        Employee obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdEmpleado()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody EmployeeDTO dto) throws Exception{
        Employee obj = service.update(convertToEntity(dto), id);
        EmployeeDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Employee>> listPage(Pageable pageable){
        Page<Employee> page = service.listPage(pageable);
        return ResponseEntity.ok(page);
    }

    private EmployeeDTO convertToDto(Employee obj){
        return modelMapper.map(obj, EmployeeDTO.class);
    }

    private Employee convertToEntity(EmployeeDTO dto){
        return modelMapper.map(dto, Employee.class);
    }
}
