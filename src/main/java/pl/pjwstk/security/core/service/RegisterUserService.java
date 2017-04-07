package pl.pjwstk.security.core.service;

import pl.pjwstk.security.core.model.RegisterUserError;
import pl.pjwstk.security.core.model.RegisterUserRequest;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.model.UserRole;
import pl.pjwstk.security.core.repository.UserRepository;

import java.util.Optional;

public class RegisterUserService {
    private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<RegisterUserError> register(RegisterUserRequest registerUserRequest) {
        if (!registerUserRequest.getPassword().equals(registerUserRequest.getConfirmPassword())) {
            return Optional.of(RegisterUserError.PASSWORDS_NOT_MATCH);
        }

        Optional<User> userOptional = userRepository.findByUsername(registerUserRequest.getUsername());

        if (userOptional.isPresent()) {
            return Optional.of(RegisterUserError.USER_EXISTS);
        }

        User user = new User(
                registerUserRequest.getUsername(),
                registerUserRequest.getPassword(),
                registerUserRequest.getEmail(),
                UserRole.REGULAR
        );

        userRepository.save(user);
        return Optional.empty();
    }
}
