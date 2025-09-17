package com.example.JpaPractice.Controllers;

import com.example.JpaPractice.Models.User;
import com.example.JpaPractice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/save")
    public ResponseEntity<User> userSave(@RequestBody User user){
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/list")
    public List<User> userList(){
        return userService.findAll();
    }
}
