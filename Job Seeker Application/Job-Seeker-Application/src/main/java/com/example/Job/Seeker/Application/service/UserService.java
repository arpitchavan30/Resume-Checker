package com.example.Job.Seeker.Application.service;
import com.example.Job.Seeker.Application.exception.UserException;
import com.example.Job.Seeker.Application.model.User;
import com.example.Job.Seeker.Application.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createUser(User user) {

         User savedUser=userRepository.save(user);

        return savedUser;
    }

    public User updateUser(Long userId, User updatedUser) {
        Optional<User> optional=userRepository.findById(userId);

        if(optional.isPresent() == false){
            throw new UserException("User with id "+userId+" is ot exists. ");
        }

        User user=optional.get();

        user.setEmail(updatedUser.getEmail());
        user.setOrganization(updatedUser.getOrganization());
        user.setPassword(updatedUser.getPassword());
        user.setUsername(updatedUser.getUsername());
        user.setRegistrationNumber(updatedUser.getRegistrationNumber());

        User savedResponse=userRepository.save(user);

        return savedResponse;

    }

    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    public User deactivateUser(Long userId){
        Optional<User> optionalUser=userRepository.findByIdAndActiveTrue(userId);

        if(optionalUser.isPresent()){
            User user=optionalUser.get();

            user.setActive(false);
          User savedResponse=userRepository.save(user);

          return savedResponse;
        }

        throw new UserException("User not found or already deactivated");
    }

    @Transactional
    public void deleteUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
        } else {
            throw new UserException("User not found with ID: " + userId);
        }
    }
}
