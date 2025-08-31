package com.example.JpaPractice.services;
import com.example.JpaPractice.models.User;
import com.example.JpaPractice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void save(String name){
        User user = new User();
        user.setName(name);

    }

    public User getById(Long id){
        return userRepository.getById(id);
    }

    public User getByName(String name){
        return userRepository.getByName(name);
    }
}
