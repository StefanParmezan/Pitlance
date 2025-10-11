package com.example.Pitlance.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {
    @GetMapping("/register")
    public String register(){
        return "Register";
    }

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/profile")
    public String profile(){
        return "Profile";
    }
}
