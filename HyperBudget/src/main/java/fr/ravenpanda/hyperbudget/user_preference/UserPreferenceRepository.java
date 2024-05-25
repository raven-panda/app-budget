package fr.ravenpanda.hyperbudget.user_preference;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "user_preference")
public interface UserPreferenceRepository extends JpaRepository<UserPreferenceEntity, Long> {

}
