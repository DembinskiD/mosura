package pl.mosura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.adm_addresses;

@Repository
public interface AddressesRepository extends JpaRepository<adm_addresses, Long> {

}
