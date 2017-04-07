package pl.pjwstk.security.core.service;

import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.model.UserRole;
import pl.pjwstk.security.core.repository.UserRepository;

public class AssignUserRoleToUserService {
    private final UserRepository userRepository;

    public AssignUserRoleToUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void assign(String username, UserRole userRole) {
        User existingUser = userRepository.findByUsername(username)
                .orElseThrow(IllegalArgumentException::new);

        User updatedUser = new User(existingUser, userRole);
        userRepository.save(updatedUser);
    }
}
