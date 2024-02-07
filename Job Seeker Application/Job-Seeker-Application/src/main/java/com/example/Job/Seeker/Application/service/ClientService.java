package com.example.Job.Seeker.Application.service;

import com.example.Job.Seeker.Application.model.Client;
import com.example.Job.Seeker.Application.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Client createClient(Client client) {
       Client client1=clientRepository.save(client);

       return client1;
    }
}
