package pl.pjwstk.security.core;

import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.model.UserRole;

public class UserTestBuilder {

    public static User regular() {
        return new User("regular", "regular", "regular@example.com", UserRole.REGULAR);
    }

    public static User premium() {
        return new User("premium", "premium", "premium@example.com", UserRole.PREMIUM);
    }

    public static User admin() {
        return new User("admin", "admin", "admin@example.com", UserRole.ADMIN);
    }
}
