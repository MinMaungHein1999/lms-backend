package com.lms.common.controller;

import com.lms.common.model.User;
import com.lms.common.model.UserRole;
import com.lms.common.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lms.common.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/roles")
public class RoleController {
    private UserRoleService userRoleService;

    @Autowired
    public RoleController(UserRoleService userRoleService){
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public ResponseEntity<List<UserRole>> getAllRoles(){
        return ResponseEntity.ok(this.userRoleService.getAll());
    }

}
