package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.adm_cities;
import pl.mosura.entity.adm_countries;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<adm_countries, Long> {

    @Query("SELECT record FROM adm_cities record where record.id=:id")
    List<adm_cities> getCityById(@Param("id")long cityId);
}
