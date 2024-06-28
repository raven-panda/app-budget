package fr.ravenpanda.hyperbudget.controller;

import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.model.User;
import fr.ravenpanda.hyperbudget.repository.UserRepository;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/user")
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return repository.findById(id).isEmpty()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(repository.findById(id).orElse(null));
    }

    @GetMapping("/search/email")
    public ResponseEntity<User> getByEmail(@RequestParam String value) {
        return repository.findByEmail(value).isEmpty()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(repository.findByEmail(value).orElse(null));
    }

    @GetMapping("/search/username")
    public ResponseEntity<User> getByUsername(@RequestParam String value) {
        return repository.findByUsername(value).isEmpty()
            ? ResponseEntity.notFound().build()
            : ResponseEntity.ok(repository.findByUsername(value).orElse(null));
    }

    @GetMapping("/search/role")
    public ResponseEntity<List<User>> getAllByRole(@RequestParam RoleEnum value) {
        return ResponseEntity.ok(repository.findAllByRole(value));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(repository.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
        if(repository.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.save(user));
    }

}
