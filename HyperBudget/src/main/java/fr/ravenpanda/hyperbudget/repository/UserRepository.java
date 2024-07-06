package fr.ravenpanda.hyperbudget.repository;

import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.model.UserModel;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Table
@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{

	Optional<UserModel> findByUsername(String username);

	Optional<UserModel> findByEmail(String email);

	List<UserModel> findAllByRole(RoleEnum role);


}
