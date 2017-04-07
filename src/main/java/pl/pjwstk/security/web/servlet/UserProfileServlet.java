package pl.pjwstk.security.web.servlet;

import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.model.User;
import pl.pjwstk.security.core.service.FindUserProfileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/userProfile")
public class UserProfileServlet extends HttpServlet {
    private final FindUserProfileService findUserProfileService = ApplicationContext.findUserProfileService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> userOptional = findUserProfileService.find();

        if (userOptional.isPresent()) {
            req.setAttribute("userProfile", userOptional.get());
            req.getRequestDispatcher("/WEB-INF/userProfile.jsp").forward(req, resp);
        }
    }
}
