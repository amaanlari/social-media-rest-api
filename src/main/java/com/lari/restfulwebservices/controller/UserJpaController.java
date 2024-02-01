package com.lari.restfulwebservices.controller;

import com.lari.restfulwebservices.exception.UserNotFoundException;
import com.lari.restfulwebservices.model.Post;
import com.lari.restfulwebservices.model.User;
import com.lari.restfulwebservices.repository.UserRepository;
import com.lari.restfulwebservices.service.UserDaoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/jpa")
public class UserJpaController {
    private final UserDaoServiceImpl service;
    private final UserRepository repository;

    public UserJpaController(UserDaoServiceImpl service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/users")
    public void save(@RequestBody User user) {
        System.out.println("Controller\n"+user);
        repository.save(user);
        System.out.println("After save\n"+user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable long id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: "+id);
        }
        return user.get().getPosts();
    }
}
