package fr.ravenpanda.hyperbudget.service;

import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.dto.UserDto;
import fr.ravenpanda.hyperbudget.model.User;

import java.util.List;

public interface UserService {

    UserDto findById(Integer id);
    Boolean existsById(Integer id);

    List<UserDto> findAll();

    UserDto findByEmail(String email);
    Boolean existsByEmail(String email);

    UserDto findByUsername(String username);
    Boolean existsByUsername(String username);

    List<UserDto> findAllByRole(RoleEnum role);

    Boolean deleteById(Integer id);

    UserDto save(UserDto user);

    UserDto update(Integer id, User user);

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}
