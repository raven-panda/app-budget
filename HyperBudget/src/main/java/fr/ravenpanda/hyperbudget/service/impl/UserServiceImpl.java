package fr.ravenpanda.hyperbudget.service.impl;

import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.model.User;
import fr.ravenpanda.hyperbudget.repository.UserRepository;
import fr.ravenpanda.hyperbudget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findById(Integer id) {
        return userRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public Boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email).map(this::toDto).orElse(null);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public UserDto findByUsername(String username) {
        return userRepository.findByUsername(username).map(this::toDto).orElse(null);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public List<UserDto> findAllByRole(RoleEnum role) {
        return userRepository.findAllByRole(role).stream().map(this::toDto).toList();
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (!userRepository.existsById(id)) return false;

        userRepository.deleteById(id);
        return true;
    }

    @Override
    public UserDto save(UserDto user) {
        User savedUser = userRepository.save(toEntity(user));
        savedUser.setIsEditWarnEnabled(true);
        return toDto(savedUser);
    }

    @Override
    public UserDto update(Integer id, User user) {
        if (!userRepository.existsById(id)) return null;
        user.setId(id);

        User savedUser = userRepository.save(user);
        return toDto(savedUser);
    }

    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .password(user.getPassword())
            .role(user.getRole())
            .theme(user.getTheme())
            .createdAt(user.getCreatedAt())
            .updatedAt(user.getUpdatedAt())
            .periodType(user.getPeriodType())
            .isEditWarnEnabled(user.getIsEditWarnEnabled())
            .build();
    }

    @Override
    public User toEntity(UserDto dto) {
        return User.builder()
            .id(dto.getId())
            .username(dto.getUsername())
            .email(dto.getEmail())
            .password(dto.getPassword())
            .role(dto.getRole())
            .createdAt(dto.getCreatedAt())
            .updatedAt(dto.getUpdatedAt())
            .theme(dto.getTheme())
            .periodType(dto.getPeriodType())
            .isEditWarnEnabled(dto.getIsEditWarnEnabled())
            .build();
    }

}
