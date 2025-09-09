package com.example.library_Management_System.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api")
public class HelloControoller {


  @GetMapping("/hello")
  public String hello() {
    return "Hello, Library Management System!";
  }
  
}
