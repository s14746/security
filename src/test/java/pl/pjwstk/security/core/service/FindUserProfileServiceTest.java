package pl.pjwstk.security.core.service;

import org.junit.Test;
import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.UserTestBuilder;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.repository.LoggedUserRepository;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FindUserProfileServiceTest {
    private final LoggedUserRepository loggedUserRepository = ApplicationContext.loggedUserRepository;
    private final FindUserProfileService findUserProfileService = ApplicationContext.findUserProfileService;

    @Test
    public void shouldFindUserProfile() throws Exception {
        // given
        loggedUserRepository.setLoggedUser(UserTestBuilder.regular());

        // when
        Optional<User> user = findUserProfileService.find();

        // then
        assertThat(user.isPresent()).isTrue();
    }

    @Test
    public void shouldNotFindUserProfile() throws Exception {
        // given
        loggedUserRepository.setLoggedUser(null);

        // when
        Optional<User> user = findUserProfileService.find();

        // then
        assertThat(user.isPresent()).isFalse();
    }
}