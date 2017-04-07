package pl.pjwstk.security.core.service;

import pl.pjwstk.security.core.model.LoginUserError;
import pl.pjwstk.security.core.model.LoginUserRequest;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.repository.LoggedUserRepository;
import pl.pjwstk.security.core.repository.UserRepository;

import java.util.Optional;

public class LoginUserService {
    private final UserRepository userRepository;
    private final LoggedUserRepository loggedUserRepository;

    public LoginUserService(UserRepository userRepository, LoggedUserRepository loggedUserRepository) {
        this.userRepository = userRepository;
        this.loggedUserRepository = loggedUserRepository;
    }

    public Optional<LoginUserError> login(LoginUserRequest loginUserRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginUserRequest.getUsername());

        if (!userOptional.isPresent()) {
            return Optional.of(LoginUserError.USER_NOT_FOUND);
        }

        User user = userOptional.get();

        if (!user.getPassword().equals(loginUserRequest.getPassword())) {
            return Optional.of(LoginUserError.INVALID_PASSWORD);
        }

        loggedUserRepository.setLoggedUser(user);
        return Optional.empty();
    }
}
