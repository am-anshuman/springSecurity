package org.aman.springSecurity.controller;

import org.aman.springSecurity.dto.UserRegistrationRequestDto;
import org.aman.springSecurity.dto.UserRegistrationResponseDto;
import org.aman.springSecurity.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponseDto> register(
            @RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {

        UserRegistrationResponseDto userRegistrationResponseDto =
                authService.register(userRegistrationRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(userRegistrationResponseDto);
    }
}
