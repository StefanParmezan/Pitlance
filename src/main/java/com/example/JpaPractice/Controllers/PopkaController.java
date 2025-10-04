package com.example.JpaPractice.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PopkaController {
    @RequestMapping("/popka")
    public ResponseEntity<String> popka(){
        return ResponseEntity.ok("popka");
    }
}
