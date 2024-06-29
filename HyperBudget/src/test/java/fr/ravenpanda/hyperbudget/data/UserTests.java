package fr.ravenpanda.hyperbudget.data;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.model.User;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
@SpringBootTest
public class UserTests {
    public static User user1 = User.builder()
        .role(RoleEnum.USER)
        .email(new RandomString(10).nextString() + "@" + new RandomString(5).nextString() + ".com")
        .username("User1")
        .password("user11234")
        .theme(PreferredThemeEnum.LIGHT)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(true)
        .build();

    public static UserDto userDto1 = UserDto.builder()
        .role(RoleEnum.USER)
        .email(new RandomString(10).nextString() + "@" + new RandomString(5).nextString() + ".com")
        .username("User1")
        .password("user11234")
        .theme(PreferredThemeEnum.LIGHT)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(true)
        .build();

    public static User user2 = User.builder()
        .role(RoleEnum.USER)
        .email("aaaa@testing.org")
        .username("User2")
        .password("user21234")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.YEARLY)
        .isEditWarnEnabled(false)
        .build();

    public static UserDto userDto2 = UserDto.builder()
        .role(RoleEnum.USER)
        .email("aaaa@testing.org")
        .username("User2")
        .password("user21234")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.YEARLY)
        .isEditWarnEnabled(false)
        .build();

    public static User admin1 = User.builder()
        .role(RoleEnum.ADMIN)
        .email("bro@administrator.org")
        .username("UserAdmin")
        .password("4321admin")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(false)
        .build();

    public static UserDto adminDto1 = UserDto.builder()
        .role(RoleEnum.ADMIN)
        .email("bro@administrator.org")
        .username("UserAdmin")
        .password("4321admin")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(false)
        .build();
}
