package com.hotel.service.Implementaciones;

import com.hotel.model.Customer;
import com.hotel.model.ServiceHotel;
import com.hotel.repository.IServiceHotelRepository;
import com.hotel.repository.IGenericRepository;
import com.hotel.service.IServiceHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceHotelService extends GenericService<ServiceHotel,Integer>   implements IServiceHotelService {

    private final IServiceHotelRepository repo;
    @Override
    protected IGenericRepository<ServiceHotel, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<ServiceHotel> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
