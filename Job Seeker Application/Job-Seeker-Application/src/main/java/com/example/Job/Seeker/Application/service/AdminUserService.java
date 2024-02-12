package com.example.Job.Seeker.Application.service;

import com.example.Job.Seeker.Application.exception.UserException;
import com.example.Job.Seeker.Application.model.User;
import com.example.Job.Seeker.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUsersPendingApproval() {
        return userRepository.findByActiveTrue();
    }


    public void approveUser(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(false);
            // Additional logic for role assignment or any other operations upon approval
            userRepository.save(user);
        } else {
            throw new UserException("User not found with ID: " + userId);
        }
    }


    public void rejectUser(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
        } else {
            throw new UserException("User not found with ID: " + userId);
        }
    }

}

