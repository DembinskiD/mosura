package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.rpis;

import java.util.List;
import java.util.Optional;

@Repository
public interface RpisRepository extends JpaRepository<rpis, Long> {


    @Query("SELECT record FROM rpis record where record.rpi_user_id=:id")
    List<rpis> findByUserId(@Param("id")long rpi_user_id);



    @Query("SELECT record FROM rpis record where record.hostname=:hostname")
    Optional<rpis> findByHostname(@Param("hostname")String hostname);






}
