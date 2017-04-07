package pl.pjwstk.security.web.filter;

import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.service.FindUserProfileService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/loginUser", "/registerUser"})
public class LoginAndRegisterUserFilter implements Filter {
    private final FindUserProfileService findUserProfileService = ApplicationContext.findUserProfileService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        if (findUserProfileService.find().isPresent()) {
            httpServletResponse.sendRedirect("/userProfile");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
