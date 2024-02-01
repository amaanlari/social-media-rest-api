package com.lari.restfulwebservices.repository;

import com.lari.restfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
