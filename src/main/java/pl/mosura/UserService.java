package pl.mosura;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mosura.entity.User;
import pl.mosura.repository.RoleRepository;
import pl.mosura.repository.UserRepository;

import java.security.NoSuchAlgorithmException;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;



    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public User findUserByName(String name) {
        return userRepository.getUserByName(name);
    }


    public void saveUser(User user) throws NoSuchAlgorithmException {
        user.digestPass(user.getPassword_digest());
        userRepository.save(user);
    }
}
