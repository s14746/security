package pl.pjwstk.security.core.service;

import org.junit.Test;
import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.UserTestBuilder;
import pl.pjwstk.security.core.model.LoginUserRequest;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.repository.LoggedUserRepository;
import pl.pjwstk.security.core.repository.UserRepository;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LogoutUserServiceTest {
    private final LoggedUserRepository loggedUserRepository = ApplicationContext.loggedUserRepository;
    private final LogoutUserService logoutUserService = ApplicationContext.logoutUserService;
    private final LoginUserService loginUserService = ApplicationContext.loginUserService;
    private final UserRepository userRepository = ApplicationContext.userRepository;

    @Test
    public void shouldLogoutLoggedInUser() throws Exception {
        // given
        User regularUser = UserTestBuilder.regular();
        userRepository.save(regularUser);

        loginUserService.login(new LoginUserRequest(regularUser.getUsername(), regularUser.getPassword()));

        // when
        logoutUserService.logout();

        // then
        assertThat(loggedUserRepository.getLoggedUser().isPresent()).isFalse();
    }

    @Test
    public void shouldLogoutNotLoggedInUser() throws Exception {
        // when
        logoutUserService.logout();

        // then
        assertThat(loggedUserRepository.getLoggedUser().isPresent()).isFalse();
    }
}