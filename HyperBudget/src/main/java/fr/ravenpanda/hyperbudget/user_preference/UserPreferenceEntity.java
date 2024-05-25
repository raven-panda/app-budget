package fr.ravenpanda.hyperbudget.user_preference;

import fr.ravenpanda.hyperbudget.core.enumeration.PreferredPeriodType;
import fr.ravenpanda.hyperbudget.core.enumeration.PreferredTheme;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "user_preference")
@Data
public class UserPreferenceEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private Long id;

    @Column(name = "theme", columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    private PreferredTheme theme = PreferredTheme.LIGHT;

    @Column(name = "period_type", columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    private PreferredPeriodType periodType = PreferredPeriodType.MONTHLY;

    @Column(name = "edit_warn", columnDefinition = "TINYINT")
    private Boolean isEditWarn = false;

}
