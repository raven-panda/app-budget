package fr.ravenpanda.hyperbudget.category;

import fr.ravenpanda.hyperbudget.budget.BudgetEntity;
import fr.ravenpanda.hyperbudget.user.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Entity(name = "category")
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(targetEntity = BudgetEntity.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "budget_has_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "budget_id")
    )
    private List<BudgetEntity> budgets;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
