package pl.pjwstk.security.core.service;

import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.repository.LoggedUserRepository;

import java.util.Optional;

public class FindUserProfileService {
    private final LoggedUserRepository loggedUserRepository;

    public FindUserProfileService(LoggedUserRepository loggedUserRepository) {
        this.loggedUserRepository = loggedUserRepository;
    }

    public Optional<User> find() {
        return loggedUserRepository.getLoggedUser();
    }
}
