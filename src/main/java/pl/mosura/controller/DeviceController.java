package pl.mosura.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mosura.Exceptions.RpiDeviceNotFoundException;
import pl.mosura.entity.config_groups;
import pl.mosura.entity.config_triggers;
import pl.mosura.entity.rpi_devices;
import pl.mosura.repository.ConfigurationGroupRepository;
import pl.mosura.repository.ConfigurationTriggersRepository;
import pl.mosura.repository.DeviceRepository;

import java.util.List;

@RestController
public class DeviceController {
    private DeviceRepository deviceRepository;
    private ConfigurationGroupRepository configurationGroupRepository;
    private ConfigurationTriggersRepository configurationTriggersRepository;

    @Autowired
    public DeviceController(DeviceRepository deviceRepository, ConfigurationGroupRepository configurationGroupRepository,
                            ConfigurationTriggersRepository configurationTriggersRepository) {
        this.deviceRepository = deviceRepository;
        this.configurationGroupRepository = configurationGroupRepository;
        this.configurationTriggersRepository = configurationTriggersRepository;
    }


    @GetMapping("/devices")
    public List<rpi_devices> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/devices/{id}")
    public rpi_devices getById(@PathVariable long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new RpiDeviceNotFoundException(id));
    }

    @GetMapping("/devicesByRPI/{id}")
    public List<rpi_devices> getByRPIID(@PathVariable long id) {
        return deviceRepository.findByRpi_id(id);
    }

    @GetMapping("/devicesByConfGrp/{id}")
    public List<rpi_devices> getByConfGrp(@PathVariable long id) {
        return deviceRepository.findByConfGroup(id);
    }

    @GetMapping("/confgroups")
    public List<config_groups> getConfGroups() {
        return configurationGroupRepository.findAll();
    }

    @GetMapping("/conftriggers")
    public List<config_triggers> getConfTriggers() {
        return configurationTriggersRepository.findAll();
    }
}
