package pl.pjwstk.security.web.servlet;

import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.model.RegisterUserError;
import pl.pjwstk.security.core.model.RegisterUserRequest;
import pl.pjwstk.security.core.service.RegisterUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
    private final RegisterUserService registerUserService = ApplicationContext.registerUserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/registerUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest(
                req.getParameter("username"),
                req.getParameter("password"),
                req.getParameter("confirmPassword"),
                req.getParameter("email")
        );

        Optional<RegisterUserError> registerUserError = registerUserService.register(registerUserRequest);

        if (registerUserError.isPresent()) {
            req.setAttribute("error", registerUserError.get());
            req.setAttribute("registerUserRequest", registerUserRequest);
            req.getRequestDispatcher("/WEB-INF/registerUser.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/loginUser");
        }
    }
}
