package com.impressao.Gerencimaneto3D.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressao.Gerencimaneto3D.Request.LoginRequest;
import com.impressao.Gerencimaneto3D.service.LoginSevice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth/login")
public class LoginAPIController {

    private final LoginSevice loginService;

    public LoginAPIController(LoginSevice loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<String> login(
            @Valid @RequestBody LoginRequest loginRequest) {

        boolean sucesso = loginService.login(loginRequest);

        if (!sucesso) {
            return ResponseEntity
                    .status(401)
                    .body("Usuário ou senha inválidos");
        }

        return ResponseEntity.ok("Login successful");
    }

    
}