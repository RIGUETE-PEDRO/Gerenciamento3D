package com.impressao.Gerencimaneto3D.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.service.LoginSevice;

@RestController
@RequestMapping("/api/auth/login")
public class LoginAPIController {

    private LoginSevice loginService;


    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest) {
        loginService = new LoginSevice();
        loginService.login(loginRequest);
    }

    public record LoginRequest(
            @NotBlank String username,
            @NotBlank String password) {
    }
}
