package fr.ravenpanda.hyperbudget.data;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.model.UserModel;
import fr.ravenpanda.hyperbudget.model.UserRole;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
@SpringBootTest
public class UserTests {
    public static UserModel user1 = UserModel.builder()
        .role(UserRole.builder().name("ROLE_USER").build())
        .email(new RandomString(10).nextString() + "@" + new RandomString(5).nextString() + ".com")
        .username("User1")
        .password("user11234")
        .theme(PreferredThemeEnum.LIGHT)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(true)
        .build();

    public static UserDto userDto1 = UserDto.builder()
        .role("ROLE_USER")
        .email(new RandomString(10).nextString() + "@" + new RandomString(5).nextString() + ".com")
        .username("User1")
        .password("user11234")
        .theme(PreferredThemeEnum.LIGHT)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(true)
        .build();

    public static UserModel user2 = UserModel.builder()
        .role(UserRole.builder().name("ROLE_USER").build())
        .email("aaaa@testing.org")
        .username("User2")
        .password("user21234")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.YEARLY)
        .isEditWarnEnabled(false)
        .build();

    public static UserDto userDto2 = UserDto.builder()
        .role("ROLE_USER")
        .email("aaaa@testing.org")
        .username("User2")
        .password("user21234")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.YEARLY)
        .isEditWarnEnabled(false)
        .build();

    public static UserModel admin1 = UserModel.builder()
        .role(UserRole.builder().name("ROLE_ADMIN").build())
        .email("bro@administrator.org")
        .username("UserAdmin")
        .password("4321admin")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(false)
        .build();

    public static UserDto adminDto1 = UserDto.builder()
        .role("ROLE_ADMIN")
        .email("bro@administrator.org")
        .username("UserAdmin")
        .password("4321admin")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(false)
        .build();
}
