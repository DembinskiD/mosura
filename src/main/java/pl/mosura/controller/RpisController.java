package pl.mosura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mosura.entity.rpis;
import pl.mosura.Exceptions.RpiNotFoundException;
import pl.mosura.repository.RpisRepository;

import java.util.List;

@RestController
public class RpisController {
    private RpisRepository rpisRepository;

    @Autowired
    public RpisController(RpisRepository rpisRepository) {
        this.rpisRepository = rpisRepository;
    }

    @GetMapping("/rpis")
    public List<rpis> findAllRpis() {
        return rpisRepository.findAll();
    }

    @GetMapping("/rpis/{id}")
    public rpis getRpi(@PathVariable long id) {
        return rpisRepository.findById(id)
                .orElseThrow(() -> new RpiNotFoundException(id));
    }

    @GetMapping("/rpisByUser/{rpi_user_id}")
    public List<rpis> findRPIsByUserId(@PathVariable long rpi_user_id) {
        return rpisRepository.findByUserId(rpi_user_id);
    }


}
