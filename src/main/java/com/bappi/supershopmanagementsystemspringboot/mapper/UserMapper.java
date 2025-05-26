package com.bappi.supershopmanagementsystemspringboot.mapper;

import com.bappi.supershopmanagementsystemspringboot.dto.RegistrationRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User toEntity(RegistrationRequestDto registrationRequestDto){
        String password = passwordEncoder.encode(registrationRequestDto.getPassword());
        registrationRequestDto.setPassword(password);
        return User.builder()
                .name(registrationRequestDto.getName())
                .email(registrationRequestDto.getEmail())
                .username(registrationRequestDto.getUsername())
                .password(registrationRequestDto.getPassword())
                .build();
    }
}
