//package com.bappi.supershopmanagementsystemspringboot.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}
