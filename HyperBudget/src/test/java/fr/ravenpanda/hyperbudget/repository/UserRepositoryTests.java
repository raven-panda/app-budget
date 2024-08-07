package fr.ravenpanda.hyperbudget.repository;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.data.UserTests;
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
        User savedUser1 = userRepository.save(UserTests.user1);
        User savedUser2 = userRepository.save(UserTests.user2);
        List<User> usersList = userRepository.findAll();

        assertThat(UserTests.user1).isNotNull();
        assertThat(UserTests.user2).isNotNull();
        assertThat(savedUser1.getId()).isGreaterThan(0);
        assertThat(savedUser2.getId()).isGreaterThan(0);

        assertThat(usersList).isNotNull();
        assertThat(usersList.size()).isEqualTo(2);
        assertThat(usersList).contains(savedUser1, savedUser2);
    }

    @Test
    public void UserRepository_SaveAll_ReturnSavedUsers() {
        User savedUser1 = userRepository.save(UserTests.user1);
        User savedUser2 = userRepository.save(UserTests.user2);

        assertThat(UserTests.user1).isNotNull();
        assertThat(UserTests.user2).isNotNull();
        assertThat(savedUser1.getId()).isGreaterThan(0);
        assertThat(savedUser2.getId()).isGreaterThan(0);
    }

    @Test
    public void UserRepository_GetById_ReturnUser() {
        User savedUser = userRepository.save(UserTests.user1);
        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getId()).isEqualTo(savedUser.getId());
    }

    @Test
    public void UserRepository_GetByEmail_ReturnUser() {
        User savedUser = userRepository.save(UserTests.user1);
        User foundUser = userRepository.findByEmail(savedUser.getEmail()).orElse(null);

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getId()).isEqualTo(savedUser.getId());
    }

    @Test
    public void UserRepository_GetByUsername_ReturnUser() {
        User savedUser = userRepository.save(UserTests.user1);
        User foundUser = userRepository.findByUsername(savedUser.getUsername()).orElse(null);

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getId()).isEqualTo(savedUser.getId());
    }

    @Test
    public void UserRepository_GetAllByRole_ReturnUser() {
        User savedUser1 = userRepository.save(UserTests.user1);
        User savedUser2 = userRepository.save(UserTests.user2);
        User savedAdmin = userRepository.save(UserTests.admin1);
        List<User> usersList = userRepository.findAllByRole(RoleEnum.USER);

        assertThat(UserTests.user1).isNotNull();
        assertThat(UserTests.user2).isNotNull();
        assertThat(UserTests.admin1).isNotNull();
        assertThat(savedUser1.getId()).isGreaterThan(0);
        assertThat(savedUser2.getId()).isGreaterThan(0);
        assertThat(savedAdmin.getId()).isGreaterThan(0);

        assertThat(usersList).isNotNull();
        assertThat(usersList.size()).isEqualTo(2);
        assertThat(usersList).contains(savedUser1, savedUser2).doesNotContain(savedAdmin);
    }

    @Test
    public void UserRepository_Update_ReturnUpdatedUser() {
        User originalUser = userRepository.save(UserTests.user1);

        originalUser.setEmail("another@aa.fr");
        originalUser.setUsername("UpdatedUser1");
        originalUser.setTheme(PreferredThemeEnum.DARK);
        originalUser.setPeriodType(PeriodTypeEnum.YEARLY);
        originalUser.setIsEditWarnEnabled(false);

        User updatedUser = userRepository.save(originalUser);

        assertThat(originalUser).isNotNull();
        assertThat(originalUser.getId()).isGreaterThan(0);
        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getId()).isEqualTo(originalUser.getId());

        assertThat(updatedUser.getEmail()).isEqualTo("another@aa.fr");
        assertThat(updatedUser.getUsername()).isEqualTo("UpdatedUser1");
        assertThat(updatedUser.getTheme()).isEqualTo(PreferredThemeEnum.DARK);
        assertThat(updatedUser.getPeriodType()).isEqualTo(PeriodTypeEnum.YEARLY);
        assertThat(updatedUser.getIsEditWarnEnabled()).isFalse();
    }

    @Test
    public void UserRepository_Delete_ReturnVoid() {
        User savedUser = userRepository.save(UserTests.user1);
        userRepository.deleteById(savedUser.getId());

        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);

        assertThat(savedUser).isNotNull();
        assertThat(foundUser).isNull();
    }

}
