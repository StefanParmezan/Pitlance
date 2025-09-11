package com.example.JpaPractice.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // ← не @RestController, потому что возвращаем view
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // → templates/index.html
    }
}