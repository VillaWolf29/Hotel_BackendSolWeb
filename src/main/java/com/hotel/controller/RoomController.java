package com.hotel.controller;

import com.hotel.dto.RoomDTO;
import com.hotel.model.Room;
import com.hotel.service.IRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rooms")
//@AllArgsConstructor
@RequiredArgsConstructor
public class RoomController {
    private final IRoomService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAll() throws Exception{
        List<RoomDTO> list = service.findAll().stream().map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findById(@PathVariable("id") Integer id) throws Exception{
        RoomDTO obj = convertToDto(service.findById(id));
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Room>  save(@Valid @RequestBody RoomDTO dto) throws Exception{
        Room obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getIdRoom()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody RoomDTO dto) throws Exception{
        Room obj = service.update(convertToEntity(dto), id);
        RoomDTO dto1 = convertToDto(obj);
        return ResponseEntity.ok(dto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private RoomDTO convertToDto(Room obj){
        return modelMapper.map(obj, RoomDTO.class);
    }

    private Room convertToEntity(RoomDTO dto){
        return modelMapper.map(dto, Room.class);
    }
}
