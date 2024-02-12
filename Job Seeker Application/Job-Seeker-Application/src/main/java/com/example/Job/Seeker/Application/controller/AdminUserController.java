package com.example.Job.Seeker.Application.controller;

import com.example.Job.Seeker.Application.model.User;
import com.example.Job.Seeker.Application.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/users")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/pending-approval")
    public ResponseEntity<List<User>> getUsersPendingApproval() {
        List<User> users = adminUserService.getUsersPendingApproval();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/approve/{userId}")
    public ResponseEntity<String> approveUser(@PathVariable Integer userId) {
        adminUserService.approveUser(userId);
        return ResponseEntity.ok("User approved successfully");
    }

    @PostMapping("/reject/{userId}")
    public ResponseEntity<String> rejectUser(@PathVariable Integer userId) {
        adminUserService.rejectUser(userId);
        return ResponseEntity.ok("User rejected successfully");
    }

}