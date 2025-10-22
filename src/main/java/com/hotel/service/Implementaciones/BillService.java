package com.hotel.service.Implementaciones;

import com.hotel.model.Bill;
import com.hotel.repository.IBillRepository;
import com.hotel.repository.IGenericRepository;
import com.hotel.service.IBillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillService extends GenericService <Bill, Integer> implements IBillService {

    private final IBillRepository repo;
    @Override
    protected IGenericRepository<Bill,Integer> getRepo() {
        return repo;
    }
}
