package pl.pjwstk.security.web.servlet;

import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.service.LogoutUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logoutUser")
public class LogoutUserServlet extends HttpServlet {
    private final LogoutUserService logoutUserService = ApplicationContext.logoutUserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logoutUserService.logout();
        resp.sendRedirect("/loginUser");
    }
}
