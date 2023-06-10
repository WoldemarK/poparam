package com.example.poparam.security;

import com.example.poparam.model.Person;
import com.example.poparam.repository.PersonRepository;
import com.example.poparam.security.jwt.JwtUser;
import com.example.poparam.security.jwt.JwtUserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = personRepository.findBaseUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with name - " + username + "not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
