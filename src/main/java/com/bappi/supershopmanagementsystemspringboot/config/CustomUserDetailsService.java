package com.bappi.supershopmanagementsystemspringboot.config;

import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
