package com.devsecops.vulnapp.controller;

import com.devsecops.vulnapp.model.User;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{username}")
    public String getUser(@PathVariable String username) throws Exception {
        // Intentionally vulnerable to SQL Injection
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");
        if (rs.next()) {
            return "User: " + rs.getString("username");
        }
        return "User not found";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO users (username, password) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "')");
        return "User registered: " + user.getUsername();
    }
}
