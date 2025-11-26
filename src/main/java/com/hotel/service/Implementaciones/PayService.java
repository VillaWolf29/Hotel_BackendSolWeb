package com.hotel.service.Implementaciones;

import com.hotel.model.Customer;
import com.hotel.model.Pay;
import com.hotel.repository.IGenericRepository;
import com.hotel.repository.IPayRepository;
import com.hotel.service.IPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayService extends  GenericService<Pay, Integer> implements IPayService {
    private final IPayRepository repo;
    @Override
    protected IGenericRepository<Pay, Integer> getRepo() {
        return repo;
    }
    @Override
    public Page<Pay> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
