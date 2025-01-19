package com.lms.common.controller;

import com.lms.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lms.common.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        try {
            User user = userService.findById(id).orElseThrow(() -> new Exception("User with id " + id + "Not Found!!!"));
            return ResponseEntity.ok(user);

        }catch (Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@RequestBody User user, @PathVariable Long id){
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destory(@PathVariable Long id) {
        try {
            User user = userService.findById(id).orElseThrow(() -> new Exception("User with id" + id + "Not Found!!!"));
            userService.delete(user);
        }catch (Exception e){
            return ResponseEntity.status(404).body(null);
        }
       return ResponseEntity.ok("Successfully Deleted");
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        user = userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }
}
