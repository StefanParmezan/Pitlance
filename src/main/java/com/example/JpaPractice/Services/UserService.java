package com.example.JpaPractice.Services;

import com.example.JpaPractice.Models.User.User;
import com.example.JpaPractice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public User getUserById(Long id){
        return userRepository.getUserById(id).orElseThrow();
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username).orElseThrow();
    }

    public User save(String username, String password){
        return userRepository.save(new User(username, password));
    }
}
