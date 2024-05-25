package fr.ravenpanda.hyperbudget.budget;

import fr.ravenpanda.hyperbudget.category.CategoryDto;
import fr.ravenpanda.hyperbudget.category.CategoryEntity;
import fr.ravenpanda.hyperbudget.core.enumeration.PreferredPeriodType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class BudgetDto {

    public BudgetDto(BudgetEntity entity) {
        this.id = entity.getId();
        this.maxAmount = entity.getMaxAmount();
        this.startDate = entity.getStartDate();
        this.userId = entity.getUser().getId();
        this.periodType = entity.getUserPreference().getPeriodType();
        this.categories = entity.getCategories().stream().map(CategoryDto::new).toList();
    }

    private Long id;
    private BigDecimal maxAmount;
    private LocalDate startDate;
    private Long userId;
    private PreferredPeriodType periodType;
    private List<CategoryDto> categories;

}
