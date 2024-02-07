package com.example.Job.Seeker.Application.controller;

import com.example.Job.Seeker.Application.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
}
