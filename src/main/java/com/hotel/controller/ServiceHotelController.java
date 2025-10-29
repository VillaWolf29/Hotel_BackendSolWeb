package com.hotel.controller;

import com.hotel.dto.ServiceHotelDTO;
import com.hotel.model.ServiceHotel;
import com.hotel.service.IServiceHotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/serviceshotel")
//@AllArgsConstructor
@RequiredArgsConstructor
public class ServiceHotelController {

    private final IServiceHotelService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ServiceHotelDTO>> findAll() throws Exception{
        List<ServiceHotelDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceHotelDTO> findById(@PathVariable("id") Integer id) throws Exception{
        ServiceHotelDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<ServiceHotel>  save(@Valid @RequestBody ServiceHotelDTO dto) throws Exception{
        ServiceHotel obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdServiceHotel()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceHotelDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ServiceHotelDTO dto) throws Exception{
        ServiceHotel obj = service.update(convertToEntity(dto), id);
        ServiceHotelDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ServiceHotelDTO convertToDto(ServiceHotel obj){
        return modelMapper.map(obj, ServiceHotelDTO.class);
    }

    private ServiceHotel convertToEntity(ServiceHotelDTO dto){
        return modelMapper.map(dto, ServiceHotel.class);
    }
}
