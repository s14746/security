package pl.pjwstk.security.web.servlet;

import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.model.LoginUserError;
import pl.pjwstk.security.core.model.LoginUserRequest;
import pl.pjwstk.security.core.service.LoginUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {
    private final LoginUserService loginUserService = ApplicationContext.loginUserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/loginUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginUserRequest loginUserRequest = new LoginUserRequest(
                req.getParameter("username"),
                req.getParameter("password")
        );

        Optional<LoginUserError> loginUserError = loginUserService.login(loginUserRequest);

        if (loginUserError.isPresent()) {
            req.setAttribute("error", loginUserError.get());
            req.getRequestDispatcher("/WEB-INF/loginUser.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/userProfile");
        }
    }
}
