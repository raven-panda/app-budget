package fr.ravenpanda.hyperbudget.repository;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
import fr.ravenpanda.hyperbudget.model.User;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_GetAll_ReturnAllUsers() {
        List<User> usersList = userRepository.findAll();
        assertThat(usersList).isNotNull();
    }

    /*@Test
    public void UserRepository_SaveAll_ReturnSavedUsers() {
        // Arrange
        User user = User.builder()
            .email("test@json.fr")
            .username("test")
            .password("test")
            .theme(PreferredThemeEnum.LIGHT)
            .periodType(PeriodTypeEnum.MONTHLY)
            .isEditWarnEnabled(true)
            .build();

        System.out.println(user);

        // Act
        User savedUser = userRepository.save(user);

        // Assert
        assertThat(user).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }*/

}
