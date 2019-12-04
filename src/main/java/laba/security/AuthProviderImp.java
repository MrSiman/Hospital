package laba.security;

import laba.objects.User;
import laba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderImp implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        User user = userService.getByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!!!");
        }
        String password = authentication.getCredentials().toString();
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Incorrect password!!!");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + Roles.ADMIN.toString()));
        }
        else {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + Roles.USER.toString()));
        }
        return new UsernamePasswordAuthenticationToken(user, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
