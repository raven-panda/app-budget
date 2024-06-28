package fr.ravenpanda.hyperbudget.service;

import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.model.User;
import fr.ravenpanda.hyperbudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Integer id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    List<User> findAllByRole(RoleEnum role);

    void deleteById(Integer id);

    User save(User user);

}
