package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.adm_cities;

import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<adm_cities, Long> {

    @Query("SELECT record FROM adm_cities record where record.county_id=:id")
    List<adm_cities> getCityByCounty(@Param("id")long countyId);

    @Query("SELECT record FROM adm_cities record where record.country_id=:id")
    List<adm_cities> getCityByCountry(@Param("id")long countryId);
}
