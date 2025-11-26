package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGenericService<Employee, Integer> {
    Page<Employee> listPage(Pageable pageable);
}
