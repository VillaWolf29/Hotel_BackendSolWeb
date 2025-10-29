package com.hotel.controller;



import com.hotel.model.Bill;
import com.hotel.dto.BillDTO;
import com.hotel.service.IBillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final IBillService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<BillDTO>> findAll() throws Exception{
        List<BillDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillDTO> findById(@PathVariable("id") Integer id) throws Exception{
        BillDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Bill>  save(@Valid @RequestBody BillDTO dto) throws Exception{
        Bill obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdBill()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody BillDTO dto) throws Exception{
        Bill obj = service.update(convertToEntity(dto), id);
        BillDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private BillDTO convertToDto(Bill obj){
        return modelMapper.map(obj, BillDTO.class);
    }

    private Bill convertToEntity(BillDTO dto){
        return modelMapper.map(dto, Bill.class);
    }
}

