package pl.pjwstk.security.core.service;

import pl.pjwstk.security.core.repository.LoggedUserRepository;

public class LogoutUserService {
    private final LoggedUserRepository loggedUserRepository;

    public LogoutUserService(LoggedUserRepository loggedUserRepository) {
        this.loggedUserRepository = loggedUserRepository;
    }

    public void logout() {
        loggedUserRepository.setLoggedUser(null);
    }
}
