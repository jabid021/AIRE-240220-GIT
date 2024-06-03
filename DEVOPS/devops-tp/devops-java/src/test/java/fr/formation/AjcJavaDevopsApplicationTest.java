package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.formation.config.SecurityConfig;

@SpringBootTest
class AjcJavaDevopsApplicationTest {
    @Autowired
    private SecurityConfig securityConfig;

    @Test
    void shouldSecurityConfigExists() {
        Assertions.assertNotNull(this.securityConfig);
    }
}
