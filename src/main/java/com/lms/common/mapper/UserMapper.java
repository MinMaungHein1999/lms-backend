package com.lms.common.mapper;

import com.lms.common.dto.UserDto;
import com.lms.common.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUsername());
        userDto.setAddress(user.getAddress());
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        return userDto;
    }
}
