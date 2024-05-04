package servlet.login;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("senha");

        Usuario usuario = new Usuario(email, senha, confirmaSenha);

        boolean eUsuarioValido = new UsuarioDAO().verificarCredenciais(usuario);

        if (eUsuarioValido) {

            req.getSession().setAttribute("loggedUsuario", email);

            resp.sendRedirect("encontrar-todos-produtos");

        } else {

            req.setAttribute("message", "Credenciais Inválidas!");

            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }

    }

}
