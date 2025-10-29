package com.hotel.service.Implementaciones;

import com.hotel.model.ServiceHotel;
import com.hotel.repository.IServiceHotelRepository;
import com.hotel.repository.IGenericRepository;
import com.hotel.service.IServiceHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceHotelService extends GenericService<ServiceHotel,Integer>   implements IServiceHotelService {

    private final IServiceHotelRepository repo;
    @Override
    protected IGenericRepository<ServiceHotel, Integer> getRepo() {
        return repo;
    }
}
