package ru.opali.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.opali.model.Person;
import ru.opali.repository.PersonRepository;
import ru.opali.security.jwt.JwtUserFactory;

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
        return JwtUserFactory.create(user);
    }
}
