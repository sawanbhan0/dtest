package com.devsecops.vulnapp.service;

import com.devsecops.vulnapp.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private Map<String, String> users = new HashMap<>();

    public void register(User user) {
        users.put(user.getUsername(), user.getPassword());
    }

    public boolean authenticate(String username, String password) {
        return password.equals(users.get(username)); // No hashing!
    }
}
