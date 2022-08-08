package com.example.service;

import com.example.model.Roles;
import com.example.model.User;
import com.example.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    private final UserRepos userRepos;

    public UserService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }
    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepos.findByUsername(username);
    }
    public boolean addUser(User user){
        User userFromDB = userRepos.findByUsername(user.getUsername());

        if(userFromDB != null){
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Roles.USER));
        user.setActivatoreCode(UUID.randomUUID().toString());

        userRepos.save(user);

        if(StringUtils.isEmpty(user.getEmail())){
            String message = String.format(
                    "Hello, %s! \n "+
                            "Welcome to Social. Please, visit next link http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivatoreCode()
            );

            mailSender.send(user.getEmail(), "Activation code", message);
        }

        return true;
    }
}
