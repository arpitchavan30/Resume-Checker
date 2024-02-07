package com.example.Job.Seeker.Application.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue (strategy  = GenerationType.AUTO)
    private Long id;

    private String username;
    private String organization;
    private String registrationNumber;
    private String email;
    private String password;
    private boolean active;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Client> clients=new ArrayList<>();

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Agent> agents=new ArrayList<>();

    @OneToMany(mappedBy = "users",cascade=CascadeType.ALL)
    private List<Role> roles=new ArrayList<>();

    public User() {
    }

    public User(Long id, String username, String organization, String registrationNumber, String email, String password, boolean active, List<Client> clients, List<Agent> agents, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.organization = organization;
        this.registrationNumber = registrationNumber;
        this.email = email;
        this.password = password;
        this.active = active;
        this.clients = clients;
        this.agents = agents;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }
}
