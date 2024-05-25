package fr.ravenpanda.hyperbudget.category;

import jakarta.persistence.Table;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;

@Table(name = "category")
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
