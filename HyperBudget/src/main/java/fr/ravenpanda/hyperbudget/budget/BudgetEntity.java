package fr.ravenpanda.hyperbudget.budget;

import fr.ravenpanda.hyperbudget.category.CategoryEntity;
import fr.ravenpanda.hyperbudget.user.UserEntity;
import fr.ravenpanda.hyperbudget.user_preference.UserPreferenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "budget")
@Data
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private Long id;

    @Column(name = "max_amount", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal maxAmount;

    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate startDate;

    @ManyToOne(targetEntity = UserPreferenceEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_preference_id", referencedColumnName = "id")
    private UserPreferenceEntity userPreference;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToMany(targetEntity = CategoryEntity.class, mappedBy = "budgets", fetch = FetchType.LAZY)
    private List<CategoryEntity> categories;
}
