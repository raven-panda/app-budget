package fr.ravenpanda.hyperbudget.user_preference;

import fr.ravenpanda.hyperbudget.core.enumeration.PreferredPeriodType;
import fr.ravenpanda.hyperbudget.core.enumeration.PreferredTheme;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserPreferenceService {

    public UserPreferenceDto toDto(UserPreferenceEntity entity) {
        return new UserPreferenceDto(entity);
    }

    public List<UserPreferenceDto> toDto(List<UserPreferenceEntity> entity) {
        if (entity == null) return null;
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserPreferenceEntity toEntity(UserPreferenceDto dto) {
        UserPreferenceEntity entity = new UserPreferenceEntity();

        entity.setTheme(PreferredTheme.fromString(dto.getTheme()));
        entity.setPeriodType(PreferredPeriodType.fromString(dto.getPeriodType()));
        entity.setIsEditWarn(dto.getIsEditWarn());

        return entity;
    }

    public List<UserPreferenceEntity> toEntity(List<UserPreferenceDto> dto) {
        if (dto == null) return null;
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
