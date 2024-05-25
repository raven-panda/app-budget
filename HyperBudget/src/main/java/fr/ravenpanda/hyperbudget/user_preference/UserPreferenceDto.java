package fr.ravenpanda.hyperbudget.user_preference;

import fr.ravenpanda.hyperbudget.core.enumeration.PreferredPeriodType;
import fr.ravenpanda.hyperbudget.core.enumeration.PreferredTheme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPreferenceDto {

    public UserPreferenceDto(UserPreferenceEntity entity) {
        this.id = entity.getId();
        this.theme = entity.getTheme().toString();
        this.periodType = entity.getPeriodType().toString();
        this.isEditWarn = entity.getIsEditWarn();
    }

    private Long id;
    private String theme;
    private String periodType;
    private Boolean isEditWarn;

}
