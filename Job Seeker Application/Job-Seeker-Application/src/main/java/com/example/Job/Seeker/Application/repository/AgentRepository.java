package com.example.Job.Seeker.Application.repository;

import com.example.Job.Seeker.Application.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
}
