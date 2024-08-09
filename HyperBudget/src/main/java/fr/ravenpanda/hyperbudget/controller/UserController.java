package fr.ravenpanda.hyperbudget.controller;

import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        UserDto user = service.findById(id);
        return service.existsById(id)
            ? ResponseEntity.ok(service.findById(id))
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/search/email")
    public ResponseEntity<UserDto> getByEmail(@RequestParam String value) {
        return service.existsByEmail(value) ? ResponseEntity.ok(service.findByEmail(value)) : ResponseEntity.noContent().build();
    }

    @GetMapping("/search/username")
    public ResponseEntity<UserDto> getByUsername(@RequestParam String value) {
        return service.existsByUsername(value) ? ResponseEntity.ok(service.findByUsername(value)) : ResponseEntity.noContent().build();
    }

    @GetMapping("/search/role")
    public ResponseEntity<List<UserDto>> getAllByRole(@RequestParam String value) {
        return ResponseEntity.ok(service.findAllByRole(value));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody UserDto user) {
        UserDto updatedDto = service.update(id, user);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Integer id) {
        Boolean success = service.deleteById(id);
        return success ? ResponseEntity.ok(true) : ResponseEntity.noContent().build();
    }

}
