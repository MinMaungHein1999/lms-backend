package com.lms.common.mapper;

import com.lms.common.dto.UserRoleDto;
import com.lms.common.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
  public UserRoleDto toDto(UserRole userRole){
      UserRoleDto userRoleDto = new UserRoleDto();
      userRoleDto.setId(userRole.getId());
      userRoleDto.setName(userRole.getName());
      userRoleDto.setDescription(userRole.getDescription());
      return userRoleDto;

  }
}
