package fr.ravenpanda.hyperbudget.dto.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse {
    private String token;
}
