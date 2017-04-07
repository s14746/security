package pl.pjwstk.security;

import pl.pjwstk.security.core.repository.LoggedUserRepository;
import pl.pjwstk.security.core.repository.UserRepository;
import pl.pjwstk.security.core.service.*;

public class ApplicationContext {
    public static final UserRepository userRepository = new UserRepository();
    public static final LoggedUserRepository loggedUserRepository = new LoggedUserRepository();

    public static final LoginUserService loginUserService = new LoginUserService(userRepository, loggedUserRepository);
    public static final RegisterUserService registerUserService = new RegisterUserService(userRepository);
    public static final FindUserProfileService findUserProfileService = new FindUserProfileService(loggedUserRepository);
    public static final LogoutUserService logoutUserService = new LogoutUserService(loggedUserRepository);
    public static final FindAllUsersService findAllUsersService = new FindAllUsersService(userRepository);
    public static final AssignUserRoleToUserService assignUserRoleToUserService = new AssignUserRoleToUserService(userRepository);
}
