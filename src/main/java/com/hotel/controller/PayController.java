package com.hotel.controller;

import com.hotel.dto.PayDTO;
import com.hotel.model.Pay;
import com.hotel.service.IPayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pays")
//@AllArgsConstructor
@RequiredArgsConstructor
public class PayController {
    private final IPayService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PayDTO>> findAll() throws Exception{
        List<PayDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayDTO> findById(@PathVariable("id") Integer id) throws Exception{
        PayDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Pay>  save(@Valid @RequestBody PayDTO dto) throws Exception{
        Pay obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdPay()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody PayDTO dto) throws Exception{
        Pay obj = service.update(convertToEntity(dto), id);
        PayDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private PayDTO convertToDto(Pay obj){
        return modelMapper.map(obj, PayDTO.class);
    }

    private Pay convertToEntity(PayDTO dto){
        return modelMapper.map(dto, Pay.class);
    }
}
