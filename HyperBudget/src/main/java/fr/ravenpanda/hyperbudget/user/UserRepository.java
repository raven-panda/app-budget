package fr.ravenpanda.hyperbudget.user;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "user")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
