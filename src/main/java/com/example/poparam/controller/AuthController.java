package com.example.poparam.controller;

import com.example.poparam.dto.AuthUserRequest;
import com.example.poparam.dto.RegisterUserRequest;
import com.example.poparam.dto.RegisterUserResponse;
import com.example.poparam.model.Person;
import com.example.poparam.repository.PersonRepository;
import com.example.poparam.security.jwt.JwtTokenProvider;
import com.example.poparam.service.PersonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthenticationManager manager;
    private final JwtTokenProvider provider;
    private final PersonService userService;

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthUserRequest authUserRequest) {
        try {
            String username = authUserRequest.getUsername();
            manager.authenticate(new UsernamePasswordAuthenticationToken
                (
                    username, authUserRequest.getPassword())
            );
            Person person = userService.getByUsername(username);
            if (person == null) {
                throw new UsernameNotFoundException("User with username " + username + " not found");
            }
            String token = provider.createToken(username, person.getRole());
            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Credentials incorrect.");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@RequestBody RegisterUserRequest request) {
        Person person = new Person();
        person.setUsername(request.getUsername());
        person.setPassword(request.getPassword());
        person.setFirstName(request.getFirst_name());
        person.setLastName(request.getLast_name());

        Person saved = userService.register(person);
        RegisterUserResponse response = new RegisterUserResponse(saved);

        return ResponseEntity.ok(response);
    }
}
