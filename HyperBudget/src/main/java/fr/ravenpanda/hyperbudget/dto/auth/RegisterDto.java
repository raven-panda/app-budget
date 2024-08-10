package fr.ravenpanda.hyperbudget.dto.auth;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterDto {

    private String email;
    private String username;
    private String role;
    private String password;
    private PeriodTypeEnum periodType;

}
