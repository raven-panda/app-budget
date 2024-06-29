package fr.ravenpanda.hyperbudget.service;

import fr.ravenpanda.hyperbudget.data.UserTests;
import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.model.User;
import fr.ravenpanda.hyperbudget.repository.UserRepository;
import fr.ravenpanda.hyperbudget.service.impl.UserServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void UserService_ToDto_ReturnUserDto() {
        UserDto userDto = userService.toDto(UserTests.user1);

        assertThat(UserTests.user1).isNotNull();
        assertThat(userDto).isNotNull();
        assertThat(userDto.getId()).isEqualTo(UserTests.user1.getId());
        assertThat(userDto.getRole()).isEqualTo(UserTests.user1.getRole());
        assertThat(userDto.getEmail()).isEqualTo(UserTests.user1.getEmail());
        assertThat(userDto.getUsername()).isEqualTo(UserTests.user1.getUsername());
        assertThat(userDto.getPassword()).isEqualTo(UserTests.user1.getPassword());
        assertThat(userDto.getCreatedAt()).isEqualTo(UserTests.user1.getCreatedAt());
        assertThat(userDto.getUpdatedAt()).isEqualTo(UserTests.user1.getUpdatedAt());
        assertThat(userDto.getTheme()).isEqualTo(UserTests.user1.getTheme());
        assertThat(userDto.getPeriodType()).isEqualTo(UserTests.user1.getPeriodType());
        assertThat(userDto.getIsEditWarnEnabled()).isEqualTo(UserTests.user1.getIsEditWarnEnabled());
    }

    @Test
    public void UserService_ToEntity_ReturnUserDto() {
        UserDto userDto = userService.toDto(UserTests.user1);
        User user = userService.toEntity(userDto);

        assertThat(UserTests.user1).isNotNull();
        assertThat(userDto).isNotNull();
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(userDto.getId());
        assertThat(user.getRole()).isEqualTo(userDto.getRole());
        assertThat(user.getEmail()).isEqualTo(userDto.getEmail());
        assertThat(user.getUsername()).isEqualTo(userDto.getUsername());
        assertThat(user.getPassword()).isEqualTo(userDto.getPassword());
        assertThat(user.getCreatedAt()).isEqualTo(userDto.getCreatedAt());
        assertThat(user.getUpdatedAt()).isEqualTo(userDto.getUpdatedAt());
        assertThat(user.getTheme()).isEqualTo(userDto.getTheme());
        assertThat(user.getPeriodType()).isEqualTo(userDto.getPeriodType());
        assertThat(user.getIsEditWarnEnabled()).isEqualTo(userDto.getIsEditWarnEnabled());
    }

    @Test
    public void UserService_SaveAll_ReturnUserDto() {
        when(userRepository.save(Mockito.any(User.class))).thenReturn(UserTests.user1);
        UserDto savedUser = userService.save(UserTests.userDto1);

        assertThat(savedUser).isNotNull();
    }
}
