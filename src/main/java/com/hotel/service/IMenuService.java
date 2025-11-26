package com.hotel.service;
import com.hotel.model.Menu;

import java.util.List;

public interface IMenuService extends IGenericService<Menu, Integer>{
    List<Menu> getMenusByUsername(String username);
}
