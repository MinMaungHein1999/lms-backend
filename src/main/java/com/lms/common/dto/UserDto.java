package com.lms.common.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String email;
    private String address;
    private UserRoleDto userRole;

}
