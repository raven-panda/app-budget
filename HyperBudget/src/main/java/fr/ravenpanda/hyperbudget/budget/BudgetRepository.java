package fr.ravenpanda.hyperbudget.budget;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "budget")
public interface BudgetRepository extends JpaRepository<BudgetEntity, Long>{
}
