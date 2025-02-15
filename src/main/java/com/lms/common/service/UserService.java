package com.lms.common.service;

import com.lms.common.dto.PaginationDto;
import com.lms.common.dto.UserDto;
import com.lms.common.dto.UserRoleDto;
import com.lms.common.mapper.RoleMapper;
import com.lms.common.mapper.UserMapper;
import com.lms.common.model.User;
import com.lms.common.model.UserRole;
import com.lms.common.repository.UserRepository;
import com.lms.common.repository.UserRoleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
            if(user.getUserRole() != null) {
                UserRoleDto userRoleDto = this.roleMapper.toDto(user.getUserRole());
                userDto.setUserRole(userRoleDto);
            }
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

    public PaginationDto<UserDto> getPaginatedUsers(String username, int currentPage, int pageSize) {
        long totalUsersCount = 0;

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        List<User> userList = null;
        if(username !=null && !username.trim().isEmpty()){
            userList = userRepository.findByUserNameWithPage(username, pageable);
            totalUsersCount = userRepository.findByUserName(username).size();
        }else{
            userList = userRepository.findUsersWithPagination(pageable);
            totalUsersCount = userRepository.count();
        }
        long numberOfPages = totalUsersCount / pageSize;
        List<UserDto> userDtoList = userList.stream().map(userMapper::toDto).collect(Collectors.toList());
        PaginationDto<UserDto> paginationDto = new PaginationDto<>(userDtoList, numberOfPages, numberOfPages > currentPage, totalUsersCount);
        return paginationDto;

    }
}
