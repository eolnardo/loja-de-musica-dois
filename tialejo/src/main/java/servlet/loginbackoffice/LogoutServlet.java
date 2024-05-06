package servlet.loginbackoffice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout-backoffice")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();

        req.setAttribute("message", "Sucesso no Logout!");

        req.getRequestDispatcher("backoffice.jsp").forward(req, resp);

    }

}