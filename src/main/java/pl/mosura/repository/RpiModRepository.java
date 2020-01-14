package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.rpi_modules;

@Repository
public interface RpiModRepository extends JpaRepository<rpi_modules, Long> {
}
