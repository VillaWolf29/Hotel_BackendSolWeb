package com.hotel.controller;

import com.hotel.model.Room;
import com.hotel.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
//@AllArgsConstructor
@RequiredArgsConstructor
public class RoomController {
    private final IRoomService service;

    @GetMapping
    public List<Room> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Room save(@RequestBody Room room) throws Exception{
        return service.save(room);
    }

    @PutMapping("/{id}")
    public Room update(@RequestBody Room room, @PathVariable("id") Integer id) throws Exception{
        return service.update(room ,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
