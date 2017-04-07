package pl.pjwstk.security.web.servlet;

import pl.pjwstk.security.ApplicationContext;
import pl.pjwstk.security.core.model.UserRole;
import pl.pjwstk.security.core.service.AssignUserRoleToUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/addPremiumUserRole")
public class AddPremiumUserRoleServlet extends HttpServlet {
    private final AssignUserRoleToUserService assignUserRoleToUserService = ApplicationContext.assignUserRoleToUserService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        assignUserRoleToUserService.assign(req.getParameter("username"), UserRole.PREMIUM);
        resp.sendRedirect("/users");
    }
}
