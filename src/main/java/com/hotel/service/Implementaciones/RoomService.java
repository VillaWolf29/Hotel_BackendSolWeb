package com.hotel.service.Implementaciones;

import com.hotel.model.Room;
import com.hotel.service.IRoomService;
import com.hotel.repository.IGenericRepository;
import com.hotel.repository.IRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService  extends GenericService<Room,Integer> implements IRoomService {

    private final IRoomRepository repo;
    @Override
    protected IGenericRepository<Room, Integer> getRepo() {
        return repo;
    }
}
