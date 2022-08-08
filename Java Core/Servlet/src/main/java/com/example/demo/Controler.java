package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controler {
    @GetMapping("/")
    public Users getUser(){
        return new Users(2222);
    }
}
