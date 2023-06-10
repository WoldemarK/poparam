package ru.astondevs.motorent.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.astondevs.motorent.domain.entity.users.BaseUser;
import ru.astondevs.motorent.domain.entity.users.Role;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(BaseUser user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                true,
                mapRoleToGrantedAuthority(user.getRole()));
    }

    private static GrantedAuthority mapRoleToGrantedAuthority(Role userRole) {
        return new SimpleGrantedAuthority(userRole.name());
    }
}
