package fr.ravenpanda.hyperbudget.repository;

import fr.ravenpanda.hyperbudget.model.User;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Table
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
