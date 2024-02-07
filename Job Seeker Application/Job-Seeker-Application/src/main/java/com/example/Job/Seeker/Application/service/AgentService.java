package com.example.Job.Seeker.Application.service;

import com.example.Job.Seeker.Application.model.Agent;
import com.example.Job.Seeker.Application.repository.AgentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;


    public Agent createAgent(Agent agent) {
        Agent agent1=agentRepository.save(agent);

      return agent1;
    }
}
