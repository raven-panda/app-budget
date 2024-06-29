package fr.ravenpanda.hyperbudget.data;

import fr.ravenpanda.hyperbudget.common.list.DefaultCategoryEnum;
import fr.ravenpanda.hyperbudget.model.Expense;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.math.BigDecimal;
import java.util.Date;

@TestComponent
@SpringBootTest
public class ExpenseTests {
    public static Expense expense1 = Expense.builder()
        .name("Expense 1")
        .amount(BigDecimal.valueOf(100.00))
        .date(new Date(System.currentTimeMillis() - 3555666))
        .category(DefaultCategoryEnum.ANIMALS)
        .build();

    public static Expense expense2 = Expense.builder()
        .name("Expense 2")
        .amount(BigDecimal.valueOf(423.54))
        .date(new Date(System.currentTimeMillis() - 782200))
        .category(DefaultCategoryEnum.CHILDREN)
        .build();

}
