package com.lari.restfulwebservices.repository;

import com.lari.restfulwebservices.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
