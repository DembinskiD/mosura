package pl.mosura.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mosura.entity.*;
import pl.mosura.repository.*;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class AdministrationController {
    private UserRepository userRepository;
    private AddressesRepository addressesRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private AdminRoleRepository adminRoleRepository;
    private CountyRepository countyRepository;
    private DeviceRepository deviceRepository;
    private RpisRepository rpisRepository;
    private RpiModRepository rpiModRepository;

    private rpi_users loggedRpiusers;
    private rpis chosenDev;
    Authentication auth;

    @Autowired
    public AdministrationController(UserRepository userRepository, AddressesRepository addressesRepository,
                                    CityRepository cityRepository, CountryRepository countryRepository,
                                    AdminRoleRepository adminRoleRepository, CountyRepository countyRepository,
                                    DeviceRepository deviceRepository, RpisRepository rpisRepository,
                                    RpiModRepository rpiModRepository) {
        this.userRepository = userRepository;
        this.addressesRepository = addressesRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.adminRoleRepository = adminRoleRepository;
        this.countyRepository = countyRepository;
        this.deviceRepository = deviceRepository;
        this.rpisRepository = rpisRepository;
        this.rpiModRepository = rpiModRepository;
    }


    @RequestMapping(value = "/")
    public String showIndex() {
        loggedRpiusers = null;
        auth = null;
        chosenDev = null;
        return "login";
    }


    @RequestMapping(value = "/login")
    public String login(){
        return "login";

        }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        loggedRpiusers = userRepository.getUserByName(auth.getName());
        System.out.println(loggedRpiusers.getListOfRpis());
        chosenDev = rpisRepository.findByUserId(loggedRpiusers.getId()).get(0);
        model.addAttribute("loggedUser", loggedRpiusers);
        model.addAttribute("chosenDev", chosenDev);
        System.out.println("here: " + model.getAttribute("chosenDev"));
        return "home";
    }




    }






