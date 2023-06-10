package ru.astondevs.motorent.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.repository.UserRepository;
import ru.astondevs.motorent.security.jwt.JwtUser;
import ru.astondevs.motorent.security.jwt.JwtUserFactory;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BaseUser user = userRepository.findBaseUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with name - " + username + "not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
