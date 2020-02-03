package pl.mosura.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mosura.entity.*;
import pl.mosura.repository.*;

import java.util.List;
import java.util.stream.Collectors;

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


    @Autowired
    public RestContr(UserRepository userRepository, AddressesRepository addressesRepository,
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


    @RequestMapping(value = "/getDev/{chosenDev}")
    public RestResponse getDev(@PathVariable String chosenDev) {
        RestResponse response = new RestResponse();

        rpis returnedDev;


        returnedDev = rpisRepository.findByHostname(chosenDev);


        if (returnedDev == null) {
            response.setResponseStatus(RestResponse.NOT_FOUND);
            response.setResponse("");
        } else {
            response.setResponseStatus(RestResponse.OK);
            response.setResponse(returnedDev);
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
    public userDTO getMe() {
        return userRepository.getUserByName("dawid").getDAO();
    }

    @GetMapping("/getTemp")
    public rpi_devices getTemp() {
        return deviceRepository.getOne(2L);
    }

    @GetMapping("/getCurrentTemp")
    public data_temperature getCurrentTemp(Model model) {
        model.addAttribute("hasSensors", true);
        long count = deviceRepository.getOne(2L).getDataTemperatures().size();
        return deviceRepository.getOne(2L).getDataTemperatures().stream()
                .skip(count - 1).findFirst().get();
    }

    @GetMapping("/getTempString")
    public List<String> getTempString() {
        return deviceRepository.getOne(2L).getDataTemperatures().stream()
                .map(data_temperature::getSensor_data)
                .collect(Collectors.toList());
    }
}
