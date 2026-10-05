package org.aman.springSecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDto {

    private String username;
    private String password;
}
