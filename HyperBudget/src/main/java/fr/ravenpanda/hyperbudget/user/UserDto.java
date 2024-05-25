package fr.ravenpanda.hyperbudget.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.ravenpanda.hyperbudget.user_preference.UserPreferenceDto;
import fr.ravenpanda.hyperbudget.user_preference.UserPreferenceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    public UserDto(UserEntity entity, UserPreferenceService userPreferenceService) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
        this.userPreference = userPreferenceService.toDto(entity.getUserPreference());
    }

    private Long id;
    private String email;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserPreferenceDto userPreference;

}
