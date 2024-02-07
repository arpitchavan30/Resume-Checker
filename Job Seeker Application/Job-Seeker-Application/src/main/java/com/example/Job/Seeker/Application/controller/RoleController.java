package com.example.Job.Seeker.Application.controller;

import com.example.Job.Seeker.Application.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;
}
