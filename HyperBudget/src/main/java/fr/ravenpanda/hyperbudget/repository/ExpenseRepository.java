package fr.ravenpanda.hyperbudget.repository;

import fr.ravenpanda.hyperbudget.model.Expense;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Table
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

	Optional<Expense> findByUserId(Integer userId);

}
