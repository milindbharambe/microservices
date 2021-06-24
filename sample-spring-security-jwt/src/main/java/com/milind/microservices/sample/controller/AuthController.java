package com.milind.microservices.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.milind.microservices.sample.config.CustomUserDetailsService;
import com.milind.microservices.sample.config.JWTTokenHandler;
import com.milind.microservices.sample.domain.JwtRequest;
import com.milind.microservices.sample.domain.JwtResponse;

@RestController
public class AuthController {

    @Autowired
    private JWTTokenHandler jwtTokenHandler;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw e;
        }
        
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtTokenHandler.generateToken(userDetails);
        
        return new JwtResponse(token);
    }
}
