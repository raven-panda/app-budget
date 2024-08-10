package fr.ravenpanda.hyperbudget.controller;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
import fr.ravenpanda.hyperbudget.config.security.service.JwtUtils;
import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.dto.auth.AuthResponse;
import fr.ravenpanda.hyperbudget.dto.auth.LoginDto;
import fr.ravenpanda.hyperbudget.dto.auth.RegisterDto;
import fr.ravenpanda.hyperbudget.repository.UserRoleRepository;
import fr.ravenpanda.hyperbudget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserService userService, UserRoleRepository userRoleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userRoleRepository = userRoleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto loginRequest) {
        if (userService.existsByEmail(loginRequest.getEmail())) return new ResponseEntity<>(HttpStatus.CONFLICT);

        UserDto newUserDto = UserDto.builder()
            .email(loginRequest.getEmail())
            .username(loginRequest.getUsername())
            .role(loginRequest.getRole())
            .password(encoder.encode(loginRequest.getPassword()))
            .periodType(loginRequest.getPeriodType())
            .theme(PreferredThemeEnum.LIGHT)
            .isEditWarnEnabled(true)
            .totalExpensesAmount(BigDecimal.ZERO)
            .expenses(List.of())
            .build();

        userService.save(newUserDto);

        return ResponseEntity.ok(getJwtAuthenticated(
            LoginDto.builder()
                .email(loginRequest.getEmail())
                .password(loginRequest.getPassword())
                .build()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginRequest) {
        return ResponseEntity.ok(getJwtAuthenticated(loginRequest));
    }

    private AuthResponse getJwtAuthenticated(LoginDto loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return AuthResponse.builder().token(jwtUtils.generateJwtToken(authentication)).build();
    }

}
