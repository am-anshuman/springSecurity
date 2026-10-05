package org.aman.springSecurity.service;

import org.aman.springSecurity.dto.UserRegistrationRequestDto;
import org.aman.springSecurity.dto.UserRegistrationResponseDto;
import org.aman.springSecurity.entity.User;
import org.aman.springSecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(
            UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegistrationResponseDto register(
            UserRegistrationRequestDto userRegistrationRequestDto) {

        User user = new User();

        user.setUsername(userRegistrationRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationRequestDto.getPassword()));
        user.setEnabled(true);

        userRepository.save(user);

        UserRegistrationResponseDto userRegistrationResponseDto = new UserRegistrationResponseDto();

        userRegistrationResponseDto.setUsername(user.getUsername());
        userRegistrationResponseDto.setMessage("User Registration Successful");

        return userRegistrationResponseDto;
    }
}
