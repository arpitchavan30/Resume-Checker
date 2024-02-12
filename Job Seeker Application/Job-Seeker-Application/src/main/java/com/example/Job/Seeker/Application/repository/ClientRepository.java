package com.example.Job.Seeker.Application.repository;

import com.example.Job.Seeker.Application.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
