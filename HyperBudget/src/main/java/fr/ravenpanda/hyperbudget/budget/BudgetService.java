package fr.ravenpanda.hyperbudget.budget;

import fr.ravenpanda.hyperbudget.category.CategoryService;
import fr.ravenpanda.hyperbudget.user.UserEntity;
import fr.ravenpanda.hyperbudget.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BudgetService {

    private final UserRepository userRepository;
    private final CategoryService categoryService;

    public BudgetService(UserRepository userRepository, CategoryService categoryService) {
        this.userRepository = userRepository;
        this.categoryService = categoryService;
    }

    public BudgetDto toDto(BudgetEntity entity) {
        return new BudgetDto(entity);
    }

    public List<BudgetDto> toDto(List<BudgetEntity> entityList) {
        if (entityList == null) return null;
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public BudgetEntity toEntity(BudgetDto dto) {
        BudgetEntity entity = new BudgetEntity();
        Optional<UserEntity> user = userRepository.findById(dto.getUserId());

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        entity.setMaxAmount(dto.getMaxAmount());
        entity.setCategories(categoryService.toEntity(dto.getCategories()));
        entity.setStartDate(dto.getStartDate());
        entity.setUser(user.get());
        entity.setUserPreference(user.get().getUserPreference());

        return entity;
    }

    public List<BudgetEntity> toEntity(List<BudgetDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
