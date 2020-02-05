package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.shrimps;

@Repository
public interface Dictionary extends JpaRepository<shrimps, Long> {
}
