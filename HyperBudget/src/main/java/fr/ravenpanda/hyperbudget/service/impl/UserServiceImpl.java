package fr.ravenpanda.hyperbudget.service.impl;

import fr.ravenpanda.hyperbudget.common.list.RoleEnum;
import fr.ravenpanda.hyperbudget.model.User;
import fr.ravenpanda.hyperbudget.repository.UserRepository;
import fr.ravenpanda.hyperbudget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllByRole(RoleEnum role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
