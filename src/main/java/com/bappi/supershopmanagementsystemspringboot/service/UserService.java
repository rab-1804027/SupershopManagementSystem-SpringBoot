package com.bappi.supershopmanagementsystemspringboot.service;

import com.bappi.supershopmanagementsystemspringboot.dto.RegistrationRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.mapper.UserMapper;
import com.bappi.supershopmanagementsystemspringboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void save(RegistrationRequestDto registrationRequestDto){
        User user = userMapper.toEntity(registrationRequestDto);
        userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
