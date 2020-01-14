package pl.mosura;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

class WebMvcConfigTest {

    @Test
    void passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


        assertTrue(bCryptPasswordEncoder.matches("dawid1", "$2a$10$d1NT8/4ktHb.5xMjREnhAeftAracqFzffUOYguO5RmINB6/3YCJ/G"));
    }


}