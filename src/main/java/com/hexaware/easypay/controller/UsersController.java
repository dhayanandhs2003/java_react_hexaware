package com.hexaware.easypay.controller;

import com.hexaware.easypay.entity.Users;
import com.hexaware.easypay.entity.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;
    
    
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/users")
    public String showUsersPage(Model model) {
        List<Users> userList = usersRepository.findAll();
        model.addAttribute("users", userList);
        return "users";
    }

  
    @PostMapping("/register")
    public String register(@ModelAttribute Users user, Model model) {
        usersRepository.save(user); // Insert or update
        List<Users> userList = usersRepository.findAll();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping("/getUser")
    public String getUserByEmail(@RequestParam String email, Model model) {
        Users user = usersRepository.findByEmail(email);
        model.addAttribute("updateUser", user); // Pre-fill form
        List<Users> userList = usersRepository.findAll();
        model.addAttribute("users", userList);
        return "users";
    }

   
    @GetMapping("/delete")
    public String deleteUser(@RequestParam String email, Model model) {
        Users user = usersRepository.findByEmail(email);
        if (user != null) {
            usersRepository.delete(user);
        }
        model.addAttribute("users", usersRepository.findAll());
        return "users";
    }
}
