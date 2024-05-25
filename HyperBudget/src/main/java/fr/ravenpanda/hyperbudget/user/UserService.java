package fr.ravenpanda.hyperbudget.user;

import fr.ravenpanda.hyperbudget.user_preference.UserPreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserPreferenceService userPreferenceService;

    public UserService(UserPreferenceService userPreferenceService) {
        this.userPreferenceService = userPreferenceService;
    }

    public UserDto toDto(UserEntity entity) {
        return new UserDto(entity, userPreferenceService);
    }

    public List<UserDto> toDto(List<UserEntity> entityList) {
        if (entityList == null) return null;
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserEntity toEntity(UserDto dto) {
        UserEntity entity = new UserEntity();

        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setUserPreference(userPreferenceService.toEntity(dto.getUserPreference()));

        return entity;
    }

    public List<UserEntity> toEntity(List<UserDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
