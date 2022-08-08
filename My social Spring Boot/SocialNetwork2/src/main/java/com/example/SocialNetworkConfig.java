package com.example;

import com.example.model.Roles;
import com.example.model.User;
import com.example.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SocialNetworkConfig {

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkConfig.class, args);

    }
}
