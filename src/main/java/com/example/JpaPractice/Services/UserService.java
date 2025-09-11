package com.example.JpaPractice.Services;

import com.example.JpaPractice.Models.User;
import com.example.JpaPractice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User getByUserName(String username){
        return userRepository.getUserByName(username);
    }

    public Page<User> getUsersToPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }
}
