package com.example.JpaPractice.Services;

import com.example.JpaPractice.Models.User;
import com.example.JpaPractice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User getByUserName(String username){
        return userRepository.getUserByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
