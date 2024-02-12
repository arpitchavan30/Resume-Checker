package com.example.Job.Seeker.Application.service;

import com.example.Job.Seeker.Application.exception.UserException;
import com.example.Job.Seeker.Application.model.User;
import com.example.Job.Seeker.Application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


//    public User createUser(User user) {
//
//         User savedUser=userRepository.save(user);
//
//        return savedUser;
//    }

    public User updateUser(Integer userId, User updatedUser) {
        Optional<User> optional=userRepository.findById(userId);

        if(optional.isPresent() == false){
            throw new UserException("User with id "+userId+" is ot exists. ");
        }

        User user=optional.get();

        user.setEmail(updatedUser.getEmail());
        user.setOrganization(updatedUser.getOrganization());
        user.setPassword(updatedUser.getPassword());
        user.setFirstname(updatedUser.getFirstname());
        user.setLastname(updatedUser.getLastname());
        user.setRegistrationNumber(updatedUser.getRegistrationNumber());

        User savedResponse=userRepository.save(user);

        return savedResponse;

    }

    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    public User deactivateUser(Integer userId){
        Optional<User> optionalUser=userRepository.findByIdAndActiveTrue(userId);

        if(optionalUser.isPresent()){
            User user=optionalUser.get();

            user.setActive(false);
          User savedResponse=userRepository.save(user);

          return savedResponse;
        }

        throw new UserException("User not found or already deactivated");
    }


    public void deleteUser(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
        } else {
            throw new UserException("User not found with ID: " + userId);
        }
    }
}
