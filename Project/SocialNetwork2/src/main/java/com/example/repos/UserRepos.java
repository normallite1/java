package com.example.repos;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepos extends JpaRepository<User, Long> {
    User findByUsername(String username);


}
