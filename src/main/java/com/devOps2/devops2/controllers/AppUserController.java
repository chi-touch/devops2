package com.devOps2.devops2.controllers;

import com.devOps2.devops2.dto.requests.RegisterRequest;
import com.devOps2.devops2.dto.responses.ApiResponse;
import com.devOps2.devops2.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/v1/appC")
@AllArgsConstructor
public class AppUserController {
    private UserServiceImpl userService;

    @GetMapping("/api/v1/printhello")
    public String printHello() {
        return "Hello World";
    }
}
