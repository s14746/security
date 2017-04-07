package pl.pjwstk.security.web.filter;

import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.model.UserRole;
import pl.pjwstk.security.core.service.FindUserProfileService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/users")
public class UsersFilter implements Filter {
    private final FindUserProfileService findUserProfileService = ApplicationContext.findUserProfileService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Optional<User> userOptional = findUserProfileService.find();

        if (!userOptional.isPresent()) {
            httpServletResponse.sendRedirect("/loginUser");
        } else {
            if (!userOptional.get().hasRole(UserRole.ADMIN)) {
                httpServletResponse.sendRedirect("/userProfile");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
