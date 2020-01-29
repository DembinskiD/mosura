package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.mosura.entity.rpi_users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<rpi_users, Long> {


    @Query("Select record from rpi_users record where record.username=:username")
    rpi_users getUserByName(@Param("username") String username);
}
