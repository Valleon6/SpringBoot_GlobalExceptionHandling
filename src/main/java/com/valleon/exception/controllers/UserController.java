package com.valleon.exception.controller;

import com.valleon.exception.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class UserController {

//    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public String index(Model model) {
        System.err.println("::: UserController.index :::");
        model.addAttribute("title", "Global Exception Handling With Spring Boot");
        model.addAttribute("msg", "Welcome to Dashboard!");
        model.addAttribute("userList", userService.userList());
        return "index";
    }

    @GetMapping("/getUserById")
    public String getUserById(Model model, @RequestParam("id") Long id) {
        System.err.println("::: UserController.getUserById :::");
        model.addAttribute("title", "Global Exception Handling With Spring Boot");
        model.addAttribute("msg", "Welcome User!!");
        model.addAttribute("userList", userService.userById(id));
        return "user";
    }

    @GetMapping("/userList")
    public ResponseEntity<?> userList() {
        System.err.println("::: UserController.userList :::");
        return new ResponseEntity<>(userService.userList(), HttpStatus.OK);
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<?> userById(@PathVariable("id") Long id) {
        System.err.println("::: UserController.userById :::");
        return new ResponseEntity<>(userService.userById(id), HttpStatus.OK);
    }
}