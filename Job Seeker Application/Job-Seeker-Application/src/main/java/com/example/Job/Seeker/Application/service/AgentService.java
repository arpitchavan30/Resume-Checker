package com.example.Job.Seeker.Application.service;

import com.example.Job.Seeker.Application.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;
}
