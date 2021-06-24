package com.milind.microservices.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/home")
    public String home(String name) {
        return "Hi, " + name + " !!";
    }
    
    @GetMapping("/admin")
    public String admin(String name) {
        return "Hi Admin, " + name + " !!";
    }
    
    @GetMapping("/minor")
    public String minor(String name) {
        return "Hi baby, " + name + " !!";
    }

    
}
