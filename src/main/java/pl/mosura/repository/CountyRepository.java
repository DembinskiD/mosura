package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.adm_counties;

@Repository
public interface CountyRepository extends JpaRepository<adm_counties, Long> {
}
