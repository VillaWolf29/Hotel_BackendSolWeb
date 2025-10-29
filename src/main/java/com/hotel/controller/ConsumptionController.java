package com.hotel.controller;

import com.hotel.dto.ConsumptionDTO;
import com.hotel.model.Consumption;
import com.hotel.model.Consumption;
import com.hotel.model.Customer;
import com.hotel.service.IConsumptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumptions")
//@AllArgsConstructor
@RequiredArgsConstructor
public class ConsumptionController {

    private final IConsumptionService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ConsumptionDTO>> findAll() throws Exception{
        List<ConsumptionDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumptionDTO> findById(@PathVariable("id") Integer id) throws Exception{
        ConsumptionDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Consumption>  save(@Valid @RequestBody ConsumptionDTO dto) throws Exception{
        Consumption obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdConsumption()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumptionDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ConsumptionDTO dto) throws Exception{
        Consumption obj = service.update(convertToEntity(dto), id);
        ConsumptionDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ConsumptionDTO convertToDto(Consumption obj){
        return modelMapper.map(obj, ConsumptionDTO.class);
    }

    private Consumption convertToEntity(ConsumptionDTO dto){
        return modelMapper.map(dto, Consumption.class);
    }
}
