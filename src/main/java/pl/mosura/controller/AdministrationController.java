package pl.mosura.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mosura.*;
import pl.mosura.entity.*;
import pl.mosura.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;
import java.util.List;

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



    @GetMapping("/")
    public String showIndex() {
        return "index";
    }


   @RequestMapping(value="/index")
    public String login(@ModelAttribute(name="loginForm")LoginForm loginForm, Model model) throws NoSuchAlgorithmException {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        User tempRpiusers = userRepository.getUserByName(username);

        if(tempRpiusers == null || tempRpiusers.getUsername() == null || tempRpiusers.getPassword_digest() == null) {
            model.addAttribute("loginError", true);
            return "index";
        } else if(tempRpiusers.getUsername().equals(username) && tempRpiusers.digestPass(password)) {
            return "home";
        } else {
            model.addAttribute("loginError", true);
            return "index";
        }

    }

    private User loggedUser;
    private rpis chosenDev;
    Authentication auth;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        loggedUser = userRepository.getUserByName(auth.getName());
        System.out.println(loggedUser.toString());
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("chosenDev", chosenDev);
        return "home";
    }


    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String showHomePost(Model model) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(model.getAttribute(chosenDev.toString()));
        return "home";
    }


   // @GetMapping("/users")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }



}
