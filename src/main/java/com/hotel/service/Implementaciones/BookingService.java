package com.hotel.service.Implementaciones;

import com.hotel.model.Booking;
import com.hotel.model.Customer;
import com.hotel.repository.IBookingRepository;
import com.hotel.repository.IGenericRepository;
import com.hotel.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService extends GenericService<Booking,Integer> implements IBookingService {

    private final IBookingRepository repo;
    @Override
    protected IGenericRepository<Booking,Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Booking> listPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
