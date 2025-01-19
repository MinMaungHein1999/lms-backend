package com.lms.common.service;

import com.lms.common.model.User;
import com.lms.common.model.UserRole;
import com.lms.common.repository.UserRepository;
import com.lms.common.repository.UserRoleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRoleRespository userRoleRespository;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRespository userRoleRespository) {
        this.userRepository = userRepository;
        this.userRoleRespository = userRoleRespository;
    }

    public User create(User user){
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User update(Long id, User upateUser){
        User user = this.userRepository.findById(id).orElseThrow();
        UserRole userRole = this.userRoleRespository.findById(upateUser.getUserRole().getId()).orElseThrow();

        user.setEmail(upateUser.getEmail());
        user.setUsername(upateUser.getUsername());
        user.setAddress(upateUser.getAddress());
        user.setUserRole(userRole);

        return this.userRepository.save(user);
    }

    public Optional<User> findById(long id){
        return this.userRepository.findById(id);
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
