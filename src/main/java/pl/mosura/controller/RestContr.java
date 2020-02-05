package pl.mosura.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mosura.entity.*;
import pl.mosura.repository.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestContr {
    private UserRepository userRepository;
    private AddressesRepository addressesRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private AdminRoleRepository adminRoleRepository;
    private CountyRepository countyRepository;
    private DeviceRepository deviceRepository;
    private RpisRepository rpisRepository;
    private RpiModRepository rpiModRepository;
    private Dictionary dictionary;


    @Autowired
    public RestContr(UserRepository userRepository, AddressesRepository addressesRepository,
                     CityRepository cityRepository, CountryRepository countryRepository,
                     AdminRoleRepository adminRoleRepository, CountyRepository countyRepository,
                     DeviceRepository deviceRepository, RpisRepository rpisRepository,
                     RpiModRepository rpiModRepository, Dictionary dictionary) {
        this.userRepository = userRepository;
        this.addressesRepository = addressesRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.adminRoleRepository = adminRoleRepository;
        this.countyRepository = countyRepository;
        this.deviceRepository = deviceRepository;
        this.rpisRepository = rpisRepository;
        this.rpiModRepository = rpiModRepository;
        this.dictionary = dictionary;
    }


    @RequestMapping(value = "/getDev/{chosenDev}")
    public RestResponse getDev(@PathVariable String chosenDev) {
        RestResponse response = new RestResponse();

        Optional<rpis> optional = rpisRepository.findByHostname(chosenDev);

        if (!optional.isPresent()) {
            response.setResponseStatus(RestResponse.NOT_FOUND);
            response.setResponse("");
        } else {
            response.setResponseStatus(RestResponse.OK);
            response.setResponse(new devDTO(optional.get()));
        }
        return response;
    }

    @GetMapping("/counties")
    public List<adm_counties> getCounties() {
        return countyRepository.findAll();
    }

    @GetMapping("/getMods")
    public List<rpi_modules> getModules() {
        return rpiModRepository.findAll();
    }

    @GetMapping("/getMe")
    public RestResponse getMe() {
        RestResponse response = new RestResponse();
        Optional<rpi_users> userOptional = userRepository.getUserByName("dawid");

        if(!userOptional.isPresent()) {
            response.setResponseStatus(RestResponse.NOT_FOUND);
            response.setResponse("");
        } else {
            response.setResponseStatus(RestResponse.OK);
            response.setResponse(new userDTO(userOptional.get()));
        }
        return response;
    }

    @GetMapping("/getTemp")
    public rpi_devices getTemp() {
        return deviceRepository.getOne(2L);
    }

    @GetMapping("/dictionary")
    public List<shrimps> getDictionary() {
        return dictionary.findAll();
    }


}
