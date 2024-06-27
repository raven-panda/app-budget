package fr.ravenpanda.hyperbudget.repository;

import fr.ravenpanda.hyperbudget.model.User;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table
public interface UserRepository extends JpaRepository<User, Integer>{
}
