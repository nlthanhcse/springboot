package com.springbootjap.springbootjpa.controller;

import com.springbootjap.springbootjpa.model.User;
import com.springbootjap.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/userapi")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Integer id) {
        return this.userService.getById(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }
}
