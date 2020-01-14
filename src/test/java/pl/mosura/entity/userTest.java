package pl.mosura.entity;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class userTest {
    User tempRpiusers = new User();
    String pass = "dawid1";
    String hex = "1160d18ac79efe1caec25530a64cccf2";


    @Test
    void digestPass() throws NoSuchAlgorithmException {
        tempRpiusers.setPassword_digest(hex);
        assertTrue(tempRpiusers.digestPass(pass));
    }
}