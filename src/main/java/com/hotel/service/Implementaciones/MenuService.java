package com.hotel.service.Implementaciones;

import com.hotel.model.Menu;
import com.hotel.repository.IGenericRepository;
import com.hotel.repository.IMenuRepository;
import com.hotel.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService extends GenericService<Menu, Integer> implements IMenuService {
    private final IMenuRepository repo;

    @Override
    protected IGenericRepository<Menu, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Menu> getMenusByUsername(String username) {
        return repo.getMenusByUsername(username);
    }
}
