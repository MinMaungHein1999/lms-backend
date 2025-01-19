package com.lms.common.service;

import com.lms.common.model.UserRole;
import com.lms.common.repository.UserRoleRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserRoleService {

    private UserRoleRespository userRoleRespository;

    @Autowired
    public UserRoleService(UserRoleRespository userRoleRespository){
        this.userRoleRespository = userRoleRespository;
    }

    public List<UserRole> getAll(){
        return this.userRoleRespository.findAll();
    }
}
