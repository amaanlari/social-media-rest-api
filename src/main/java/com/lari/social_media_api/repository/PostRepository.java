package com.lari.social_media_api.repository;

import com.lari.social_media_api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
