package com.lms.common.service;

import com.lms.common.model.User;
import com.lms.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User update(int id, User user){
        return this.userRepository.save(user);
    }

    public Optional<User> findById(long id){
        return this.userRepository.findById(id);
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
