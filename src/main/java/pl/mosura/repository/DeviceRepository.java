package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.rpi_devices;
import pl.mosura.entity.rpis;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<rpi_devices, Long> {

    @Query("SELECT record FROM rpi_devices record where record.rpi_id=:id")
    List<rpi_devices> findByRpi_id(@Param("id")long rpi_id);

    @Query("Select record from rpi_devices record where record.config_group_id=:id")
    List<rpi_devices> findByConfGroup(@Param("id") long configGroup);

    @Query("Select record FROM rpis record where record.hostname=:hostname")
    rpis findDevByName(@Param("hostname") String hostname);
}
