package fr.ravenpanda.hyperbudget.controller;

import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.model.User;
import fr.ravenpanda.hyperbudget.repository.UserRepository;
import fr.ravenpanda.hyperbudget.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return service.findById(id).isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(service.findById(id).orElse(null));
    }

    @GetMapping("/search/email")
    public ResponseEntity<User> getByEmail(@RequestParam String value) {
        return service.findByEmail(value).isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(service.findByEmail(value).orElse(null));
    }

    @GetMapping("/search/username")
    public ResponseEntity<User> getByUsername(@RequestParam String value) {
        return service.findByUsername(value).isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(service.findByUsername(value).orElse(null));
    }

    @GetMapping("/search/role")
    public ResponseEntity<List<User>> getAllByRole(@RequestParam RoleEnum value) {
        return ResponseEntity.ok(service.findAllByRole(value));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
        if(service.findById(id).isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(service.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id) {
        if(service.findById(id).isEmpty()) return ResponseEntity.noContent().build();
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
