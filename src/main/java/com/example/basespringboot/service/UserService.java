package com.example.basespringboot.service;

import com.example.basespringboot.entity.User;
import com.example.basespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User createRandomUser() {
        String randomUsername = generateRandomUsername();
        User user = new User(randomUsername);
        return userRepository.save(user);
    }
    
    private String generateRandomUsername() {
        String[] adjectives = {"Happy", "Smart", "Cool", "Bright", "Swift", "Bold", "Kind", "Wise", "Brave", "Calm"};
        String[] nouns = {"Tiger", "Eagle", "Dolphin", "Phoenix", "Wolf", "Lion", "Dragon", "Falcon", "Bear", "Fox"};
        
        Random random = new Random();
        String adjective = adjectives[random.nextInt(adjectives.length)];
        String noun = nouns[random.nextInt(nouns.length)];
        int number = random.nextInt(1000);
        
        return adjective + noun + number;
    }
}
