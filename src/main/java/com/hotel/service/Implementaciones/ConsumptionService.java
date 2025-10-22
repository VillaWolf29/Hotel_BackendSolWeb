package com.hotel.service.Implementaciones;


import com.hotel.model.Consumption;
import com.hotel.repository.IConsumptionRepository;
import com.hotel.repository.IGenericRepository;
import com.hotel.service.IConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumptionService extends GenericService<Consumption ,Integer> implements IConsumptionService {
    private final IConsumptionRepository repo;
    @Override
    protected IGenericRepository<Consumption, Integer> getRepo() {
        return repo;
    }
}
