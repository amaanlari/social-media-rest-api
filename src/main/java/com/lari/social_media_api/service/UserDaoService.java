package com.lari.social_media_api.service;

import com.lari.social_media_api.model.User;

import java.util.List;

public interface UserDaoService {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    void deleteById(long id);
}
