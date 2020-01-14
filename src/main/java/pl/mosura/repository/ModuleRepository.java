package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.data_modules;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<data_modules, Long> {


    @Query("Select record from data_modules record where record.enabled=true")
    List<data_modules> getEnabled();

    @Query("Select record from data_modules record where record.enabled=false")
    List<data_modules> getDisabled();


    @Query("Select record from data_modules record where record.module_id=:id")
    data_modules getByModuleId(@Param("id") long id);
}
