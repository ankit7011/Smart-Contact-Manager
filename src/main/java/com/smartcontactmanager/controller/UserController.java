package com.smartcontactmanager.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartcontactmanager.dao.UserRepository;
import com.smartcontactmanager.entities.Users;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @RequestMapping("/index")
    public String dashboard(Model model , Principal principal) 
    {
        String userName =principal.getName();
        System.out.println("UserName : " + userName);

        Users user = userRepository.getUserByUserName(userName);

        System.out.println("User" + user.toString());

        model.addAttribute("user", user);
        
        return "normal/user_dashboard";
    }
}
