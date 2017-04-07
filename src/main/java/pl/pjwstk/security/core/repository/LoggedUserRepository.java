package pl.pjwstk.security.core.repository;

import pl.pjwstk.security.core.model.User;

import java.util.Optional;

public class LoggedUserRepository {
    private User loggedUser;

    public Optional<User> getLoggedUser() {
        return Optional.ofNullable(loggedUser);
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}
