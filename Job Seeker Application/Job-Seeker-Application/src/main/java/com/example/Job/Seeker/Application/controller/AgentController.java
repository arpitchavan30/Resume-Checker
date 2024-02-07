package com.example.Job.Seeker.Application.controller;

import com.example.Job.Seeker.Application.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;
}
