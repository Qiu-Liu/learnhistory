package com.example.consul_demo.controller;

import com.example.consul_demo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consul")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello consul";
    }

    @PostMapping("/test")
    public String helloTest(@RequestBody User user) {
        return "hello consul";
    }
}
