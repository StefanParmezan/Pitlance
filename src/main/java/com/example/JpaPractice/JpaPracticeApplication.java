package com.example.JpaPractice;

import com.example.JpaPractice.models.User;
import com.example.JpaPractice.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);
        ApplicationContext context = SpringApplication.run(JpaPracticeApplication.class, args);
        UserService userService = context.getBean(UserService.class);
        userService.save("StefanParmezan");
        User user = userService.getByName("StefanParmezan");

    }
}
