package pl.pjwstk.security.core.repository;

import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.model.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("regular", "aaa", "aaa@wp.pl", UserRole.REGULAR));
        users.add(new User("premium", "aaa", "aaa@wp.pl", UserRole.PREMIUM));
        users.add(new User("admin", "aaa", "aaa@wp.pl", UserRole.ADMIN));
    }

    public void save(User user) {
        if (users.contains(user)) {
            users.set(users.indexOf(user), user);
        } else {
            users.add(user);
        }
    }

    public Optional<User> findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public List<User> findAll() {
        return users;
    }
}
