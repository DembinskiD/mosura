package pl.mosura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mosura.*;
import pl.mosura.entity.*;
import pl.mosura.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;

@Controller
public class AdministrationController {
    private UserRepository userRepository;
    private AddressesRepository addressesRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private AdminRoleRepository adminRoleRepository;
    private CountyRepository countyRepository;

    @Autowired
    public AdministrationController(UserRepository userRepository, AddressesRepository addressesRepository,
                                    CityRepository cityRepository, CountryRepository countryRepository,
                                    AdminRoleRepository adminRoleRepository, CountyRepository countyRepository) {
        this.userRepository = userRepository;
        this.addressesRepository = addressesRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.adminRoleRepository = adminRoleRepository;
        this.countyRepository = countyRepository;
    }


    @RequestMapping(value = "/")
    public String showIndex() {
        return "index";
    }


    @RequestMapping(value = "/index")
    public ModelAndView login(@ModelAttribute(name = "loginForm") LoginForm loginForm,
                              ModelAndView model) throws NoSuchAlgorithmException {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        User tempRpiUser;
        System.out.println("--");
        System.out.println("username: " + username);
        System.out.println(loginForm.getUsername());
        System.out.println(loginForm.getPassword());

        if (username == null) {
            System.out.println("username empty..");
            model.addObject("loginError", true);
            return model;
        }
        if (password == null) {
            System.out.println("password empty");
            model.addObject("loginError", true);
            return model;
        } else {
            tempRpiUser = userRepository.getUserByName(username);
            if (tempRpiUser == null) {
                System.out.println("user not found");
                model.addObject("userNotFound", true);
                return model;
            } else if (tempRpiUser.getUsername().equals(username) && tempRpiUser.digestPass(password)) {
                model.addObject("loginError", false);
                model.addObject("userNotFound", false);
                return model;
            } else return new ModelAndView("index");
        }
    }
}





