package pl.mosura.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mosura.Exceptions.DeviceNotFoundException;
import pl.mosura.entity.data_modules;
import pl.mosura.repository.ModuleRepository;

import java.util.List;

@RestController
public class ModulesController {
    private ModuleRepository moduleRepository;

    @Autowired
    public ModulesController(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @GetMapping("/modules")
    public List<data_modules> getModules() {
        return moduleRepository.findAll();
    }

    @GetMapping("/modules/{id}")
    public data_modules getById(@PathVariable long id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException(id));
    }

    @GetMapping("/modulesBy/{id}")
    public data_modules getByModuleId(@PathVariable long id) {
        return moduleRepository.getByModuleId(id);
    }

    @GetMapping("/modules/findEnabled")
    public List<data_modules> getEnabled() {
        return moduleRepository.getEnabled();
    }

    @GetMapping("/modules/findDisabled")
    public List<data_modules> getDisabled() {
        return moduleRepository.getDisabled();
    }
}
