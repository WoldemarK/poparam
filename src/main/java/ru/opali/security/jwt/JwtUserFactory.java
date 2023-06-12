package ru.opali.security.jwt;

import ru.opali.model.Person;
import ru.opali.model.Role;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
@NoArgsConstructor
public final class JwtUserFactory {
    public static JwtUser create(Person person) {
        return new JwtUser(
            person.getId(),
            person.getUsername(),
            person.getPassword(),
                true,
                mapRoleToGrantedAuthority(person.getRole()));
    }
    private static GrantedAuthority mapRoleToGrantedAuthority(Role userRole) {
        return new SimpleGrantedAuthority(userRole.name());
    }
}
