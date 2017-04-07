package pl.pjwstk.security.core.service;

import org.junit.Test;
import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.UserTestBuilder;
import pl.pjwstk.security.core.model.LoginUserError;
import pl.pjwstk.security.core.model.LoginUserRequest;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.repository.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LoginUserServiceTest {
    private final UserRepository userRepository = ApplicationContext.userRepository;
    private final LoginUserService loginUserService = ApplicationContext.loginUserService;

    @Test
    public void shouldLoginUser() throws Exception {
        // given
        User regularUser = UserTestBuilder.regular();
        userRepository.save(regularUser);

        LoginUserRequest loginUserRequest = new LoginUserRequest(regularUser.getUsername(), regularUser.getPassword());

        // when
        Optional<LoginUserError> loginUserError = loginUserService.login(loginUserRequest);

        // then
        assertThat(loginUserError.isPresent()).isFalse();
    }

    @Test
    public void shouldNotLoginUserWhenUserNotExists() throws Exception {
        // given
        LoginUserRequest loginUserRequest = new LoginUserRequest("abc", "aaa");

        // when
        Optional<LoginUserError> loginUserError = loginUserService.login(loginUserRequest);

        // then
        assertThat(loginUserError.isPresent()).isTrue();
        assertThat(loginUserError.get()).isEqualTo(LoginUserError.USER_NOT_FOUND);
    }

    @Test
    public void shouldNotLoginUserWhenPasswordIsInvalid() throws Exception {
        // given
        User regularUser = UserTestBuilder.regular();
        userRepository.save(regularUser);
        LoginUserRequest loginUserRequest = new LoginUserRequest(regularUser.getUsername(), "aaainvalid");

        // when
        Optional<LoginUserError> loginUserError = loginUserService.login(loginUserRequest);

        // then
        assertThat(loginUserError.isPresent()).isTrue();
        assertThat(loginUserError.get()).isEqualTo(LoginUserError.INVALID_PASSWORD);
    }
}