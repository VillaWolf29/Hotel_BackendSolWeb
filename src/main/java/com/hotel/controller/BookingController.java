package com.hotel.controller;

import com.hotel.dto.BookingDTO;
import com.hotel.model.Booking;
import com.hotel.model.Booking;
import com.hotel.model.Customer;
import com.hotel.service.IBookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bookings")
//@AllArgsConstructor
@RequiredArgsConstructor
public class BookingController {

    private final IBookingService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<BookingDTO>> findAll() throws Exception {
        List<BookingDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> findById(@PathVariable("id") Integer id) throws Exception {
        BookingDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Booking> save(@Valid @RequestBody BookingDTO dto) throws Exception {
        Booking obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdBooking()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody BookingDTO dto) throws Exception {
        Booking obj = service.update(convertToEntity(dto), id);
        BookingDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/pageable")
    public ResponseEntity<Page<Booking>> listPage(Pageable pageable){
        Page<Booking> page = service.listPage(pageable);
        return ResponseEntity.ok(page);
    }


    private BookingDTO convertToDto(Booking obj) {
        return modelMapper.map(obj, BookingDTO.class);
    }

    private Booking convertToEntity(BookingDTO dto) {
        return modelMapper.map(dto, Booking.class);
    }
}
