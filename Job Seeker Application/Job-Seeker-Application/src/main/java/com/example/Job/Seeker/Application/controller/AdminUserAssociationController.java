package com.example.Job.Seeker.Application.controller;

import com.example.Job.Seeker.Application.service.AdminUserAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserAssociationController {

    @Autowired
    private AdminUserAssociationService adminUserAssociationService;

    @PutMapping("/{userId}/associate")
    public ResponseEntity<String> associateUserWithClientsAndAgents(
            @PathVariable Integer userId,
            @RequestParam("clientIds") List<Integer> clientIds,
            @RequestParam("agentIds") List<Integer> agentIds) {
        adminUserAssociationService.associateUserWithClientsAndAgents(userId, clientIds, agentIds);
        return ResponseEntity.ok("User associated with clients and agents successfully");
    }


}