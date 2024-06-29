package fr.ravenpanda.hyperbudget.repository;

import fr.ravenpanda.hyperbudget.common.list.DefaultCategoryEnum;
import fr.ravenpanda.hyperbudget.data.ExpenseTests;
import fr.ravenpanda.hyperbudget.data.UserTests;
import fr.ravenpanda.hyperbudget.model.Expense;
import fr.ravenpanda.hyperbudget.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ExpenseRepositoryTests {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void ExpenseRepository_GetAll_ReturnAllUsers() {
        User savedUser = userRepository.save(UserTests.user1);
        Expense expense1 = ExpenseTests.expense1;
        Expense expense2 = ExpenseTests.expense2;
        expense1.setUser(savedUser);
        expense2.setUser(savedUser);

        Expense savedExpense1 = expenseRepository.save(expense1);
        Expense savedExpense2 = expenseRepository.save(expense2);
        List<Expense> expensesList = expenseRepository.findAll();

        assertThat(savedUser).isNotNull();
        assertThat(ExpenseTests.expense1).isNotNull();
        assertThat(ExpenseTests.expense2).isNotNull();
        assertThat(savedExpense1.getId()).isGreaterThan(0);
        assertThat(savedExpense2.getId()).isGreaterThan(0);

        assertThat(expensesList).isNotNull();
        assertThat(expensesList.size()).isEqualTo(2);
        assertThat(expensesList).contains(savedExpense1, savedExpense2);
    }

    @Test
    public void ExpenseRepository_SaveAll_ReturnSavedUsers() {
        User savedUser = userRepository.save(UserTests.user1);
        Expense expense1 = ExpenseTests.expense1;
        Expense expense2 = ExpenseTests.expense2;
        expense1.setUser(savedUser);
        expense2.setUser(savedUser);

        System.out.println(expense1);

        Expense savedExpense1 = expenseRepository.save(expense1);
        Expense savedExpense2 = expenseRepository.save(expense2);

        assertThat(savedUser).isNotNull();
        assertThat(ExpenseTests.expense1).isNotNull();
        assertThat(ExpenseTests.expense2).isNotNull();
        assertThat(savedExpense1.getId()).isGreaterThan(0);
        assertThat(savedExpense2.getId()).isGreaterThan(0);
    }

    @Test
    public void ExpenseRepository_GetById_ReturnUser() {
        User savedUser = userRepository.save(UserTests.user1);
        Expense expense = ExpenseTests.expense1;
        expense.setUser(savedUser);

        Expense savedExpense = expenseRepository.save(expense);
        Expense foundExpense = expenseRepository.findById(savedExpense.getId()).orElse(null);

        assertThat(savedUser).isNotNull();
        assertThat(savedExpense).isNotNull();
        assertThat(foundExpense).isNotNull();
        assertThat(foundExpense.getId()).isEqualTo(savedExpense.getId());
    }

    @Test
    public void ExpenseRepository_Update_ReturnUpdatedUser() {
        Date newDate = new Date(System.currentTimeMillis() - 3555666);

        User savedUser1 = userRepository.save(UserTests.user1);
        User savedUser2 = userRepository.save(UserTests.user2);
        Expense expense1 = ExpenseTests.expense1;
        expense1.setUser(savedUser1);

        Expense originalExpense = expenseRepository.save(expense1);

        originalExpense.setUser(savedUser2);
        originalExpense.setName("UpdatedExpense1");
        originalExpense.setAmount(BigDecimal.valueOf(200.00));
        originalExpense.setCategory(DefaultCategoryEnum.CHILDREN);
        originalExpense.setDate(newDate);

        Expense updatedExpense = expenseRepository.save(originalExpense);

        assertThat(savedUser1).isNotNull();
        assertThat(savedUser2).isNotNull();

        assertThat(originalExpense).isNotNull();
        assertThat(originalExpense.getId()).isGreaterThan(0);
        assertThat(updatedExpense).isNotNull();
        assertThat(updatedExpense.getId()).isEqualTo(originalExpense.getId());

        assertThat(updatedExpense.getUser()).isEqualTo(savedUser2);
        assertThat(updatedExpense.getName()).isEqualTo("UpdatedExpense1");
        assertThat(updatedExpense.getAmount()).isEqualTo(BigDecimal.valueOf(200.00));
        assertThat(updatedExpense.getCategory()).isEqualTo(DefaultCategoryEnum.CHILDREN);
        assertThat(updatedExpense.getDate()).isEqualTo(newDate);
    }

    @Test
    public void ExpenseRepository_Delete_ReturnVoid() {
        User savedUser = userRepository.save(UserTests.user1);
        Expense expense = ExpenseTests.expense1;
        expense.setUser(savedUser);

        Expense savedExpense = expenseRepository.save(expense);
        expenseRepository.deleteById(savedExpense.getId());

        Expense foundExpense = expenseRepository.findById(savedExpense.getId()).orElse(null);

        assertThat(savedUser).isNotNull();
        assertThat(savedExpense).isNotNull();
        assertThat(foundExpense).isNull();
    }

}
