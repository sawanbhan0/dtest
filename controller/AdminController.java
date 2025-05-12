package com.devsecops.vulnapp.controller;

import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/deserialize")
    public String deserialize(@RequestBody byte[] data) throws Exception {
        // Insecure deserialization
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object obj = ois.readObject();
        return "Deserialized: " + obj.toString();
    }
}
