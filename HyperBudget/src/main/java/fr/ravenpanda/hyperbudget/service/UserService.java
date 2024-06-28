package fr.ravenpanda.hyperbudget.service;

import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.model.User;
import fr.ravenpanda.hyperbudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllByRole(RoleEnum role) {
        return userRepository.findAllByRole(role);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
