package fr.ravenpanda.hyperbudget.config.security;

import fr.ravenpanda.hyperbudget.config.security.service.AuthTokenFilter;
import fr.ravenpanda.hyperbudget.config.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class HyperBudgetSecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;


    @Autowired
    protected HyperBudgetSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth ->
                auth.requestMatchers("/error").permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/api/auth/**")).permitAll()

                    .requestMatchers(new AntPathRequestMatcher("/api/user/{id}")).hasAnyRole("USER", "ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/api/user/change-password/{id}")).hasAnyRole("USER", "ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/api/user/**")).hasRole("ADMIN")

                    .requestMatchers(new AntPathRequestMatcher("/api/expense/search/**")).hasAnyRole("USER", "ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/api/expense/{id}")).hasAnyRole("USER", "ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/api/expense", "POST")).hasAnyRole("USER", "ADMIN")
                    .requestMatchers(new AntPathRequestMatcher("/api/expense/**")).hasRole("ADMIN")
                    .anyRequest().authenticated()
            );

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
