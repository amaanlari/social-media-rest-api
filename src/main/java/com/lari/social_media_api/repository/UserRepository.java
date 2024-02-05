package com.lari.social_media_api.repository;

import com.lari.social_media_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
