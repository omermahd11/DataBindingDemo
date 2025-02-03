package com.example.databindingdemo.service;

import com.example.databindingdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users = new ArrayList<>();


    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }


    //delete

    public void deleteUser(int id) {

        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                break;
            }
        }
    }

    //update

    
}
