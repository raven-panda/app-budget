package fr.ravenpanda.hyperbudget.controller;

import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.model.UserRole;
import fr.ravenpanda.hyperbudget.repository.UserRoleRepository;
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
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private final UserRoleRepository roleRepository;

    public UserController(UserService service, UserRoleRepository roleRepository) {
        this.service = service;
        this.roleRepository = roleRepository;
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
        Optional<UserRole> role = roleRepository.findByName(value);

        return role.map(userRole -> ResponseEntity.ok(service.findAllByRole(userRole))).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {
        if (roleRepository.findByName(user.getRole()).isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody UserDto user) {
        if (roleRepository.findByName(user.getRole()).isEmpty() || !service.checkPassword(id, user.getPassword())) {
            return ResponseEntity.badRequest().build();
        }

        UserDto updatedDto = service.update(id, user);
        return updatedDto != null ? ResponseEntity.ok(updatedDto) : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/{password}")
    public ResponseEntity<Boolean> update(@PathVariable Integer id, @PathVariable String password) {
        if (!service.checkPassword(id, password)) return ResponseEntity.badRequest().build();
        Boolean success = service.deleteById(id);

        return success ? ResponseEntity.ok(true) : ResponseEntity.noContent().build();
    }

}
