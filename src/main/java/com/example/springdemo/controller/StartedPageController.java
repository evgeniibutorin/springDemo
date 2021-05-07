package com.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartedPageController {

    @GetMapping(value = "/home")
    public String listEmployees() {
        return "home";

    }
}
