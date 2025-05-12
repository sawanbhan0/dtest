package com.devsecops.vulnapp.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome(@RequestParam(defaultValue = "guest") String name) {
        // Intentionally vulnerable to XSS
        return "<h1>Welcome, " + name + "</h1>";
    }

    @PostMapping("/run")
    public String runCommand(@RequestParam String cmd) throws Exception {
        // Intentionally vulnerable to command injection
        Process process = Runtime.getRuntime().exec(cmd);
        return "Executed: " + cmd;
    }
}
