package fr.ravenpanda.hyperbudget.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;

import java.util.Arrays;
import java.util.Objects;

@Configuration
public class HyperBudgetEnvConfig {

    private final static String ENV_FILE_PATH = ".env";

    @Value("${SPRING_PROFILES_ACTIVE}")
    private static String ENVIRONMENT;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        if (Objects.equals(ENVIRONMENT, "local")) {
            configurer.setLocation(new FileSystemResource(ENV_FILE_PATH));
        }
        return configurer;
    }

}
