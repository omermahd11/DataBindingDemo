package com.example.databindingdemo.controller;

import com.example.databindingdemo.model.User;
import com.example.databindingdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

     @Autowired
     UserService userService ;

    @GetMapping("/hello")
    public String action1( Model model) {
        User user = new User(1,"Tim", 22);
        model.addAttribute("user", user);
        return "main";
    }
    @PostMapping("/adduser")
    public String action2( Model model , @ModelAttribute User user) {
     //   User user = new User(1,"Tim", 22);

        System.out.println(user);

        userService.addUser(user);

        return "page1";

    }

    @GetMapping("/users")
    public String action3( Model model) {

        model.addAttribute("users", userService.getUsers());
        return "page2";
    }

    @GetMapping("/deleteuser")
    public String action4(Model model, @RequestParam int id) {

        userService.deleteUser(id);
        model.addAttribute("users", userService.getUsers());
        return "page2";

    }

}
