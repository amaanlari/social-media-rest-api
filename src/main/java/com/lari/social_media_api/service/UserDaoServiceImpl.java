package com.lari.social_media_api.service;

import com.lari.social_media_api.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoServiceImpl implements UserDaoService {

    static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1L, "Shreyashi", LocalDate.of(2002, 1, 3)));
        users.add(new User(2L, "Amisha", LocalDate.of(2001, 4, 14)));
        users.add(new User(3L, "Zehra", LocalDate.of(2003, 6, 30)));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void save(User user) {
        System.out.println(user);
        users.add(user);
    }

    @Override
    public void deleteById(long id) {
        users.remove(
                users.stream()
                        .filter(user -> user.getId().equals(id))
                        .findFirst()
                        .orElseThrow(RuntimeException::new)
        );
    }
}
