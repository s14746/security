package pl.pjwstk.security.core.service;

import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.repository.UserRepository;

import java.util.List;

public class FindAllUsersService {
    private final UserRepository userRepository;

    public FindAllUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
