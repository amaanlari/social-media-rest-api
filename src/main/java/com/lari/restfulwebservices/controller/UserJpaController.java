package com.lari.restfulwebservices.controller;

import com.lari.restfulwebservices.exception.UserNotFoundException;
import com.lari.restfulwebservices.model.Post;
import com.lari.restfulwebservices.model.User;
import com.lari.restfulwebservices.repository.PostRepository;
import com.lari.restfulwebservices.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v2/jpa")
public class UserJpaController {
    private final UserRepository userRepository;
    private final PostRepository  postRepository;

    public UserJpaController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        User user =  userRepository.findById(id)
                .isPresent() ? userRepository.findById(id).get() : null;
        if (user == null) {
            throw new UserNotFoundException("User with id = "+id+" not found");
        } else {
            return user;
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: "+id);
        }
        return user.get().getPosts();
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public Post retrievePostByIdForUser(@PathVariable long id, @PathVariable long postId) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: "+id);
        }
        return user.get().getPosts().stream().filter(post1 -> post1.getId() == postId).findFirst().orElseThrow();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable long id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: "+id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
