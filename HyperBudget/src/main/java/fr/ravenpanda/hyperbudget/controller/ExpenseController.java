package fr.ravenpanda.hyperbudget.controller;

import fr.ravenpanda.hyperbudget.dto.ExpenseDto;
import fr.ravenpanda.hyperbudget.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExpenseDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getById(@PathVariable Integer id) {
        ExpenseDto user = service.findById(id);
        return service.existsById(id)
            ? ResponseEntity.ok(service.findById(id))
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/search/user")
    public ResponseEntity<ExpenseDto> getAllByRole(@RequestParam Integer id) {
        ExpenseDto expense = service.findByUserId(id);
        return expense != null ? ResponseEntity.ok(expense) : ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> save(@RequestBody ExpenseDto expense) {
        ExpenseDto savedDto = service.save(expense);
        return savedDto != null ? ResponseEntity.ok(savedDto) : ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> update(@PathVariable Integer id, @RequestBody ExpenseDto user) {
        ExpenseDto updatedDto = service.update(id, user);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Integer id) {
        Boolean success = service.deleteById(id);
        return success ? ResponseEntity.ok(true) : ResponseEntity.noContent().build();
    }

}
