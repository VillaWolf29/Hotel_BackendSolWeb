package com.hotel.service.Implementaciones;

import com.hotel.model.Customer;
import com.hotel.model.Employee;

import com.hotel.repository.IEmployeeRepository;
import com.hotel.repository.IGenericRepository;
import com.hotel.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService extends  GenericService<Employee, Integer> implements IEmployeeService {
    private final IEmployeeRepository repo;
    @Override
    protected IGenericRepository<Employee, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Employee> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

}
