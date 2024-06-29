package fr.ravenpanda.hyperbudget.service;

import fr.ravenpanda.hyperbudget.dto.ExpenseDto;
import fr.ravenpanda.hyperbudget.model.Expense;

import java.util.List;

public interface ExpenseService {

    ExpenseDto findById(Integer id);
    Boolean existsById(Integer id);

    List<ExpenseDto> findAll();

    ExpenseDto findByUserId(Integer userId);

    Boolean deleteById(Integer id);

    ExpenseDto save(ExpenseDto expense);

    ExpenseDto update(Integer id, ExpenseDto expense);

    ExpenseDto toDto(Expense expense);

    Expense toEntity(ExpenseDto expenseDto);

}
