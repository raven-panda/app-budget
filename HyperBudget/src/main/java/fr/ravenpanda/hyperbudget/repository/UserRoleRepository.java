package fr.ravenpanda.hyperbudget.repository;

import fr.ravenpanda.hyperbudget.model.UserRole;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Table
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{

	Optional<UserRole> findByName(String name);

}
