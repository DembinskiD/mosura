package pl.mosura;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mosura.entity.rpi_users;
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


    public rpi_users findUserByName(String name) {
        return userRepository.getUserByName(name);
    }


    public void saveUser(rpi_users rpiusers) throws NoSuchAlgorithmException {
        rpiusers.digestPass(rpiusers.getPassword_digest());
        userRepository.save(rpiusers);
    }
}
