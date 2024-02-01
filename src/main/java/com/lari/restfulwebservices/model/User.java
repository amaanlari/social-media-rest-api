package com.lari.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue(generator = "USER_SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "USER_SEQUENCE_GENERATOR",
            allocationSize = 1,
            initialValue = 4,
            sequenceName = "USER_DETAIL_SEQ"
    )
    private long id;

    private String username;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;
    public User() {
    }

    public User(Long id, String username, LocalDate dateOfBirth) {
        this.id = id;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", posts=" + posts +
                '}';
    }
}
