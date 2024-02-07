package com.example.Job.Seeker.Application.controller;

import com.example.Job.Seeker.Application.model.Agent;
import com.example.Job.Seeker.Application.repository.AgentRepository;
import com.example.Job.Seeker.Application.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/createAgent")
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        Agent response=agentService.createAgent(agent);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
