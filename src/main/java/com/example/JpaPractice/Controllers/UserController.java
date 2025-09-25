package com.example.JpaPractice.Controllers;

import com.example.JpaPractice.Models.User.User;
import com.example.JpaPractice.Models.User.DTO.UserDto;
import com.example.JpaPractice.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    @RequestMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto.getUsername(), userDto.getPassword()));
    }
}
