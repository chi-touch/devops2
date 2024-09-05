package com.devOps2.devops2.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/appC")
@AllArgsConstructor
public class AppUserController {


    @GetMapping("/printhello")
    public String printHello() {
        return "Hello World";
    }
}
