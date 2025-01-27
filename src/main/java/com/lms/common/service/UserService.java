package com.lms.common.service;

import com.lms.common.dto.UserDto;
import com.lms.common.dto.UserRoleDto;
import com.lms.common.mapper.RoleMapper;
import com.lms.common.mapper.UserMapper;
import com.lms.common.model.User;
import com.lms.common.model.UserRole;
import com.lms.common.repository.UserRepository;
import com.lms.common.repository.UserRoleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private String createUserName;
    private final RoleMapper roleMapper;
    private final UserMapper userMapper;
    private final UserRoleRespository userRoleRespository;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRespository userRoleRespository, UserMapper userMapper, RoleMapper roleMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userRoleRespository = userRoleRespository;
        this.roleMapper = roleMapper;
    }

    public User create(User user){
        if(user.getUsername().contains("hein")){
            this.createUserName = user.getUsername(); // NULL
        }

        System.out.println("Contains Name : "+ this.createUserName); // NULL
        return this.userRepository.save(user);
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(user -> {
            UserDto userDto = this.userMapper.toDto(user);
            UserRoleDto userRoleDto = this.roleMapper.toDto(user.getUserRole());
            userDto.setUserRole(userRoleDto);
            return userDto;
        }).collect(Collectors.toList());
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
