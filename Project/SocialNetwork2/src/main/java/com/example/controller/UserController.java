package com.example.controller;

import com.example.model.Roles;
import com.example.model.User;
import com.example.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserRepos userRepos;

    @GetMapping
    public String getUserList(Model model){
        model.addAttribute("users", userRepos.findAll());

        return "userList";
    }
    @GetMapping("/{id}/edit")
    public String userEdit( @PathVariable Long id, Model model){
        model.addAttribute("user", userRepos.getById(id));
        model.addAttribute("roles", Roles.values());

        return "userEdit";
    }
    @PostMapping("/{id}/edit")
    public String userSave(@ModelAttribute("user") User user){

        userRepos.save(user);

        return "redirect:/user";
    }
}
