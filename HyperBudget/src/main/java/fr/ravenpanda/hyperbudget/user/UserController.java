package fr.ravenpanda.hyperbudget.user;

import fr.ravenpanda.hyperbudget.user_preference.UserPreferenceRepository;
import fr.ravenpanda.hyperbudget.user_preference.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired private UserPreferenceRepository userPreferenceRepository;
    @Autowired private UserService userService;
    @Autowired private UserPreferenceService userPreferenceService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        Optional<List<UserDto>> users = Optional.ofNullable(userService.toDto(userRepository.findAll()));
        if (users.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userService.toDto(userRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.toDto(userRepository.findById(id).orElse(null)));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        userPreferenceRepository.save(userPreferenceService.toEntity(userDto.getUserPreference()));
        return ResponseEntity.ok(userService.toDto(userRepository.save(userService.toEntity(userDto))));
    }
}