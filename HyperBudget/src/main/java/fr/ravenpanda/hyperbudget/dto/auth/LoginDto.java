package fr.ravenpanda.hyperbudget.dto.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginDto {

    private String email;
    private String password;

}
