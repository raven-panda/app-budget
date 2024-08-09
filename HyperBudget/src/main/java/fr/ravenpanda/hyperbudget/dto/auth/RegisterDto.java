package fr.ravenpanda.hyperbudget.dto.auth;

import lombok.Data;

@Data
public class RegisterDto {

    private String email;
    private String username;
    private String role;
    private String password;

}
