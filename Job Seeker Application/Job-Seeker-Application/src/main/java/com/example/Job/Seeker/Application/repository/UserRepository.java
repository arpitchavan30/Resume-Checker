package com.example.Job.Seeker.Application.repository;

import com.example.Job.Seeker.Application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByEmail(String email);
    public Optional<User> findByIdAndActiveTrue(Integer userId);
    public List<User> findByActiveTrue();
}
