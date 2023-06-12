package ru.opali.service.impl;

import ru.opali.model.Person;
import ru.opali.model.Role;
import ru.opali.repository.PersonRepository;
import ru.opali.security.jwt.JwtTokenProvider;
import ru.opali.service.PersonService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider provider;
    public UserServiceImpl(PersonRepository personRepository, BCryptPasswordEncoder passwordEncoder, JwtTokenProvider provider) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.provider = provider;
    }
    public Person register(Person person) {
        Role role = Role.USER;
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(role);

        return personRepository.save(person);
    }
    @Override
    public List<Person> getAllUsers() {
        return personRepository.findAll();
    }

    @Override
    public Person getByUsername(String username) {
        return personRepository.findBaseUserByUsername(username);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public String getRole(String token) {
        Jws<Claims> claimsJws = provider.decodingToken(token);
        return claimsJws.getBody().get("role").toString();
    }
}
