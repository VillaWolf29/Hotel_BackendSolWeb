package com.hotel.repository;
import com.hotel.model.User;

public interface IUserRepository extends IGenericRepository<User, Integer>{
    User findOneByUsername(String username);
}
