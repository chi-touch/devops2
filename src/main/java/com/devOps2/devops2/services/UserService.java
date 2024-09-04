package com.devOps2.devops2.services;

import com.devOps2.devops2.dto.requests.LoginRequest;
import com.devOps2.devops2.dto.requests.RegisterRequest;
import com.devOps2.devops2.dto.responses.LoginResponse;
import com.devOps2.devops2.dto.responses.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse login(LoginRequest loginRequest);
}
