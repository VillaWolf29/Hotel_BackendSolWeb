package com.hotel.service.Implementaciones;

import com.hotel.model.Customer;
import com.hotel.repository.ICustomerRepository;
import com.hotel.repository.IGenericRepository;
import com.hotel.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService extends  GenericService<Customer, Integer> implements ICustomerService {

    private final ICustomerRepository repo;
    @Override
    protected IGenericRepository<Customer, Integer> getRepo() {
        return repo;
    }
}
