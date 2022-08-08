package com.example.controller;

import com.example.model.Message;
import com.example.model.User;
import com.example.repos.MessageRepo;
import com.example.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Controller
public class MainController {

    @Autowired
    private UserRepos userRepos;
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String getLogin(){
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String getMain(@AuthenticationPrincipal User user,
                          Model model){
       Set<Message> messages = messageRepo.findMessageWhereUser(user);

        model.addAttribute("messages", messages);
        model.addAttribute("user", user.getUsername());
        return "main";
    }
    @PostMapping("/main")
    public String createPost(@AuthenticationPrincipal User user,
                             @RequestParam String message,
                             @RequestParam String tag){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MMM-dd HH:mm:ss", Locale.UK);
        LocalDateTime time = LocalDateTime.now();
        String data = formatter.format(time);
        Message messages = new Message(message,tag, data, user);
        messageRepo.save(messages);

        return "redirect:/main";
    }


}
