package fr.ravenpanda.hyperbudget.service.impl;

import fr.ravenpanda.hyperbudget.dto.ExpenseDto;
import fr.ravenpanda.hyperbudget.model.Expense;
import fr.ravenpanda.hyperbudget.repository.ExpenseRepository;
import fr.ravenpanda.hyperbudget.repository.UserRepository;
import fr.ravenpanda.hyperbudget.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ExpenseDto findById(Integer id) {
        return expenseRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public Boolean existsById(Integer id) {
        return expenseRepository.existsById(id);
    }

    @Override
    public List<ExpenseDto> findAll() {
        return expenseRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ExpenseDto findByUserId(Integer userId) {
        Expense expense = expenseRepository.findByUserId(userId).orElse(null);
        return expense != null ? toDto(expense) : null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (!expenseRepository.existsById(id)) return false;

        expenseRepository.deleteById(id);
        return true;
    }

    @Override
    public ExpenseDto save(ExpenseDto expense) {
        if(!userRepository.existsById(expense.getUserId())) return null;
        Expense savedExpense = expenseRepository.save(toEntity(expense));
        return toDto(savedExpense);
    }

    @Override
    public ExpenseDto update(Integer id, ExpenseDto expense) {
        if (!expenseRepository.existsById(id)) return null;
        if (!userRepository.existsById(expense.getUserId())) return null;
        expense.setId(id);

        Expense updatedExpense = expenseRepository.save(toEntity(expense));
        return toDto(updatedExpense);
    }

    @Override
    public ExpenseDto toDto(Expense expense) {
        return ExpenseDto.builder()
            .id(expense.getId())
            .userId(expense.getUser().getId())
            .name(expense.getName())
            .amount(expense.getAmount())
            .date(expense.getDate())
            .category(expense.getCategory())
            .createdAt(expense.getCreatedAt())
            .updatedAt(expense.getUpdatedAt())
            .build();
    }

    @Override
    public Expense toEntity(ExpenseDto expenseDto) {
        return Expense.builder()
            .id(expenseDto.getId())
            .user(userRepository.findById(expenseDto.getUserId()).orElse(null))
            .name(expenseDto.getName())
            .amount(expenseDto.getAmount())
            .date(expenseDto.getDate())
            .category(expenseDto.getCategory())
            .createdAt(expenseDto.getCreatedAt())
            .updatedAt(expenseDto.getUpdatedAt())
            .build();
    }
}
