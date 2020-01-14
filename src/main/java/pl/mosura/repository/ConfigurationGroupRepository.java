package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.config_groups;

@Repository
public interface ConfigurationGroupRepository extends JpaRepository<config_groups, Long> {
}
