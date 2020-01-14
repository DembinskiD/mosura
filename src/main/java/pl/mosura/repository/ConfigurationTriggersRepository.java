package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.config_triggers;

@Repository
public interface ConfigurationTriggersRepository extends JpaRepository<config_triggers, Long> {
}
