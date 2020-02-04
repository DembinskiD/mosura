package pl.mosura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mosura.entity.rpi_users;
import pl.mosura.entity.rpis;
import pl.mosura.repository.*;


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

    private rpi_users loggedUser;
    private rpis chosenDev;
    private Authentication auth;

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
        loggedUser = null;
        auth = null;
        chosenDev = null;
        return "login";
    }


    @RequestMapping(value = "/login")
    public String login(){
        return "login";
        }
//todo dodac pakiet jezykowy dla kazdego uzytkownika, tablice z jezykami- pierw angielski(domyslny) i polski.

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        loggedUser = userRepository.getUserByName(auth.getName());
//        System.out.println(loggedUser.getListOfRpis());
        chosenDev = rpisRepository.findByUserId(loggedUser.getId()).get(0);
//        model.addAttribute("hasSensors", false);
        model.addAttribute("logoutText", "Logout");
        model.addAttribute("hasOneDev", loggedUser.getListOfRpis().size() == 1);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("chosenDev", chosenDev);
        return "home";
    }






    }






