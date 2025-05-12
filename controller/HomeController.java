package com.devsecops.vulnapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String xssVulnerable(@RequestParam(defaultValue = "guest") String name) {
        return "<h1>Hello, " + name + "</h1>"; // XSS
    }

    @PostMapping("/exec")
    public String exec(@RequestParam String cmd) throws Exception {
        Process p = Runtime.getRuntime().exec(cmd); // RCE
        return "Executed: " + cmd;
    }
}
