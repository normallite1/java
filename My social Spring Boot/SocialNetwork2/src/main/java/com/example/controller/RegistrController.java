package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrController {

    @Autowired
    private UserService userService;

    @GetMapping("/registr")
    public String registr(){

        return "registr";
    }

    @PostMapping("/registr")
    public String addUser(User user, Model model){

        if(!userService.addUser(user)){
            model.addAttribute("message", "User exists");
            return "registr";
        }

        return "redirect:/login";
    }
}
