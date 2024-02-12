package com.example.Job.Seeker.Application.repository;

import com.example.Job.Seeker.Application.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole,Integer> {
}
