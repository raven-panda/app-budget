package fr.ravenpanda.hyperbudget.category;

import fr.ravenpanda.hyperbudget.budget.BudgetDto;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {

    public CategoryDto(CategoryEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.userId = entity.getUser().getId();
        this.budgets = entity.getBudgets().stream().map(BudgetDto::new).toList();
    }

    private Long id;
    private String name;
    private Long userId;
    private List<BudgetDto> budgets;

}
