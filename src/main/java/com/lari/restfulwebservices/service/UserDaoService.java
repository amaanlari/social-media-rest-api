package com.lari.restfulwebservices.service;

import com.lari.restfulwebservices.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserDaoService {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    void deleteById(long id);
}
