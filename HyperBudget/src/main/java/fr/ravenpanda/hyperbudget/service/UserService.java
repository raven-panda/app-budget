package fr.ravenpanda.hyperbudget.service;

import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.model.UserModel;
import fr.ravenpanda.hyperbudget.model.UserRole;

import java.util.List;

public interface UserService {

    UserDto findById(Integer id);
    Boolean existsById(Integer id);

    Boolean checkPassword(Integer id, String password);

    List<UserDto> findAll();

    UserDto findByEmail(String email);
    Boolean existsByEmail(String email);

    UserDto findByUsername(String username);
    Boolean existsByUsername(String username);

    List<UserDto> findAllByRole(UserRole role);

    Boolean deleteById(Integer id);

    UserDto save(UserDto user);

    UserDto update(Integer id, UserDto user);

    UserDto toDto(UserModel user);

    UserModel toEntity(UserDto userDto);

}
