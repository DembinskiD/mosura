package pl.mosura.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mosura.entity.adm_user_role;

@Repository
public interface RoleRepository extends JpaRepository<adm_user_role, Long> {


}
