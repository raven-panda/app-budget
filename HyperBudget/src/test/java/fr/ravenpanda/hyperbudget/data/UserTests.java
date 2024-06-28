package fr.ravenpanda.hyperbudget.data;

import fr.ravenpanda.hyperbudget.common.list.PeriodTypeEnum;
import fr.ravenpanda.hyperbudget.common.list.PreferredThemeEnum;
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
        .email(new RandomString(10).nextString() + "@" + new RandomString(5).nextString() + ".com")
        .username("User1")
        .password("user11234")
        .theme(PreferredThemeEnum.LIGHT)
        .periodType(PeriodTypeEnum.MONTHLY)
        .isEditWarnEnabled(true)
        .build();

    public static User user2 = User.builder()
        .email("aaaa@testing.org")
        .username("User2")
        .password("user21234")
        .theme(PreferredThemeEnum.DARK)
        .periodType(PeriodTypeEnum.YEARLY)
        .isEditWarnEnabled(false)
        .build();
}
