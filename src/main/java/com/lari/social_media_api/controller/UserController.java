package com.lari.social_media_api.controller;

import com.lari.social_media_api.model.User;
import com.lari.social_media_api.service.UserDaoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private final UserDaoServiceImpl service;

    public UserController(UserDaoServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/users")
    public void save(@RequestBody User user) {
        System.out.println("Controller\n"+user);
        service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
