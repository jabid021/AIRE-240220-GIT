package fr.formation.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("jeremy")) {
            return User.withUsername(username)
                // .password("{noop}123456")
                // .password(this.passwordEncoder.encode("123456"))
                .password("$2a$10$CIrDPLmtVmKcluefZEZlV.yRV.18jqC1VjoHYgLIqEeDwhPCEJKfK")
                .roles("USER")
                .build();
        }

        throw new UsernameNotFoundException("User not found.");
    }
}
