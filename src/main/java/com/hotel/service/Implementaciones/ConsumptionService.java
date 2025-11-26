package com.hotel.service.Implementaciones;


import com.hotel.model.Consumption;
import com.hotel.model.Customer;
import com.hotel.repository.IConsumptionRepository;
import com.hotel.repository.IGenericRepository;
import com.hotel.service.IConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumptionService extends GenericService<Consumption ,Integer> implements IConsumptionService {
    private final IConsumptionRepository repo;
    @Override
    protected IGenericRepository<Consumption, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Consumption> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
