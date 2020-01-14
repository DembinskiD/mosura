package pl.mosura.entity;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.mosura.UserService;
import pl.mosura.repository.RoleRepository;
import pl.mosura.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {


    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;

    private UserService userServiceTest;
    private User user;


    @Test
    public void testUserFind() {
        String username = "dawid";
        user = mockUserRepository.getUserByName(username);

        System.out.println("here " + user.getUsername());
        assertEquals(username, user.getUsername());
    }


}
