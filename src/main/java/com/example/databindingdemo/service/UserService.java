package com.example.databindingdemo.service;

import com.example.databindingdemo.model.User;
import com.example.databindingdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    //List<User> users = new ArrayList<>();

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
      //  users.add(user);

        userRepository.save(user);
    }


    //delete

    public void deleteUser(int id) {
     /*
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                break;
            }
        }

        */

        userRepository.deleteById(id);

    }

    public User getUser(int id) {
      User user=  userRepository.findById(id).orElse(null);

      return user;
    }
    //update

    
}
