package com.example.Job.Seeker.Application.controller;

import com.example.Job.Seeker.Application.model.Client;
import com.example.Job.Seeker.Application.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/createClient")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
       Client response=clientService.createClient(client);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
