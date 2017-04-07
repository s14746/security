package pl.pjwstk.security.core.service;

import org.junit.Test;
import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.UserTestBuilder;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.model.UserRole;
import pl.pjwstk.security.core.repository.UserRepository;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AssignUserRoleToUserServiceTest {
    private final AssignUserRoleToUserService assignUserRoleToUserService = ApplicationContext.assignUserRoleToUserService;
    private final UserRepository userRepository = ApplicationContext.userRepository;

    @Test
    public void shouldAssignPremiumRole() throws Exception {
        // given
        User regularUser = UserTestBuilder.regular();
        userRepository.save(regularUser);

        // when
        assignUserRoleToUserService.assign(regularUser.getUsername(), UserRole.PREMIUM);

        // then
        Optional<User> userOptional = userRepository.findByUsername(regularUser.getUsername());
        assertThat(userOptional.get().hasRole(UserRole.PREMIUM)).isTrue();
    }

    @Test
    public void shouldAssignRegularRole() throws Exception {
        // given
        User premiumUser = UserTestBuilder.premium();
        userRepository.save(premiumUser);

        // when
        assignUserRoleToUserService.assign(premiumUser.getUsername(), UserRole.REGULAR);

        // then
        Optional<User> userOptional = userRepository.findByUsername(premiumUser.getUsername());
        assertThat(userOptional.get().hasRole(UserRole.REGULAR)).isTrue();
    }
}