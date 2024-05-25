package fr.ravenpanda.hyperbudget.user;

import fr.ravenpanda.hyperbudget.user_preference.UserPreferenceEntity;
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
        return ResponseEntity.ok(userService.toDto(userRepository.save(userService.toEntity(userDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();
        UserPreferenceEntity userPreference = userPreferenceRepository.findById(user.getUserPreference().getId()).orElse(null);
        if (userPreference == null) return ResponseEntity.notFound().build();

        userPreference.setTheme(userPreferenceService.toEntity(userDto.getUserPreference()).getTheme());
        userPreference.setPeriodType(userPreferenceService.toEntity(userDto.getUserPreference()).getPeriodType());
        userPreference.setIsEditWarn(userPreferenceService.toEntity(userDto.getUserPreference()).getIsEditWarn());

        userPreferenceRepository.save(userPreference);

        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return ResponseEntity.ok(userService.toDto(userRepository.save(user)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @RequestParam String password) {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) return ResponseEntity.notFound().build();

        if (!user.getPassword().equals(password)) return ResponseEntity.badRequest().build();

        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
