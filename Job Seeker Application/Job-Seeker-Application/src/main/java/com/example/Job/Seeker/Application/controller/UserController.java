package com.example.Job.Seeker.Application.controller;

import com.example.Job.Seeker.Application.model.User;
import com.example.Job.Seeker.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping ("/createUser")
    public ResponseEntity<User> createUser(@RequestBody   User userObj) {
       User response=userService.createUser(userObj);
        return new  ResponseEntity(response,HttpStatus.CREATED );
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        List<User> users=userService.getAllUser();

        return users;
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User user=userService.updateUser(userId, updatedUser);
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @PutMapping("/deactivateUser/{userId}")
    public ResponseEntity<User> deactivateUser(@PathVariable Long userId){
        User response=userService.deactivateUser(userId);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
