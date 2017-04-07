package pl.pjwstk.security.core.service;

import org.junit.Test;
import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.UserTestBuilder;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.repository.UserRepository;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FindAllUsersServiceTest {
    private final UserRepository userRepository = ApplicationContext.userRepository;
    private final FindAllUsersService findAllUsersService = ApplicationContext.findAllUsersService;

    @Test
    public void shouldFindAllUsers() throws Exception {
        // given
        User regularUser = UserTestBuilder.regular();
        User premiumUser = UserTestBuilder.premium();
        User adminUser = UserTestBuilder.admin();
        userRepository.save(regularUser);
        userRepository.save(premiumUser);
        userRepository.save(adminUser);

        // when
        List<User> allUsers = findAllUsersService.findAll();

        // then
        assertThat(allUsers).hasSize(3);
    }
}