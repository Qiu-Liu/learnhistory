package com.example.consul_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consul")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello consul";
    }
}
