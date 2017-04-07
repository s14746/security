package pl.pjwstk.security.core.service;

import org.junit.Test;
import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.model.RegisterUserError;
import pl.pjwstk.security.core.model.RegisterUserRequest;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RegisterUserServiceTest {
    private final RegisterUserService registerUserService = ApplicationContext.registerUserService;

    @Test
    public void shouldNotRegisterUserWhenPasswordsDoesNotMatch() throws Exception {
        // given
        RegisterUserRequest registerUserRequest = new RegisterUserRequest("username", "aaa", "bbb", "username@example.com");

        // when
        Optional<RegisterUserError> registerUserError = registerUserService.register(registerUserRequest);

        // then
        assertThat(registerUserError.isPresent()).isTrue();
        assertThat(registerUserError.get()).isEqualTo(RegisterUserError.PASSWORDS_NOT_MATCH);
    }

    @Test
    public void shouldNotRegisterUserWhenUserAlreadyExists() throws Exception {
        // given
        RegisterUserRequest registerUserRequest = new RegisterUserRequest("username", "aaa", "aaa", "username@example.com");
        registerUserService.register(registerUserRequest);

        // when
        Optional<RegisterUserError> registerUserError2 = registerUserService.register(registerUserRequest);

        // then
        assertThat(registerUserError2.isPresent()).isTrue();
        assertThat(registerUserError2.get()).isEqualTo(RegisterUserError.USER_EXISTS);
    }

    @Test
    public void shouldRegisterUser() throws Exception {
        // given
        RegisterUserRequest registerUserRequest = new RegisterUserRequest("usernamenew", "aaa", "aaa", "username@example.com");

        // when
        Optional<RegisterUserError> registerUserError = registerUserService.register(registerUserRequest);

        // then
        assertThat(registerUserError.isPresent()).isFalse();
    }
}