package com.example.Job.Seeker.Application.service;

import com.example.Job.Seeker.Application.exception.UserException;
import com.example.Job.Seeker.Application.model.Agent;
import com.example.Job.Seeker.Application.model.Client;
import com.example.Job.Seeker.Application.model.User;
import com.example.Job.Seeker.Application.repository.AgentRepository;
import com.example.Job.Seeker.Application.repository.ClientRepository;
import com.example.Job.Seeker.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserAssociationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AgentRepository agentRepository;


    public void associateUserWithClientsAndAgents(Integer userId, List<Integer> clientIds, List<Integer> agentIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found with ID: " + userId));

        List<Client> clients = clientRepository.findAllById(clientIds);
        List<Agent> agents = agentRepository.findAllById(agentIds);

        user.setClients(clients);
        user.setAgents(agents);

        userRepository.save(user);
    }

}