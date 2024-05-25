package fr.ravenpanda.hyperbudget.category;

import fr.ravenpanda.hyperbudget.budget.BudgetService;
import fr.ravenpanda.hyperbudget.user.UserEntity;
import fr.ravenpanda.hyperbudget.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final UserRepository userRepository;
    private final BudgetService budgetService;

    public CategoryService(UserRepository userRepository, BudgetService budgetService) {
        this.userRepository = userRepository;
        this.budgetService = budgetService;
    }

    public CategoryDto toDto(CategoryEntity categoryEntity) {
        return new CategoryDto(categoryEntity);
    }

    public List<CategoryDto> toDto(List<CategoryEntity> categoryEntityList) {
        if (categoryEntityList == null) return null;
        return categoryEntityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public CategoryEntity toEntity(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        Optional<UserEntity> user = userRepository.findById(categoryDto.getUserId());
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        categoryEntity.setId(categoryDto.getId());
        categoryEntity.setName(categoryDto.getName());
        categoryEntity.setBudgets(budgetService.toEntity(categoryDto.getBudgets()));
        categoryEntity.setUser(user.get());

        return categoryEntity;
    }

    public List<CategoryEntity> toEntity(List<CategoryDto> categoryDtoList) {
        if (categoryDtoList == null) return null;
        return categoryDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
