package servlet.logincliente;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login-cliente")
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
        String grupo = req.getParameter("grupo");

        Usuario usuario = new Usuario(email, grupo, senha, confirmaSenha);

        System.out.println(grupo);

        boolean eUsuarioValido = new UsuarioDAO().verificarCredenciais(usuario);

        if (eUsuarioValido && usuario.getGrupo().equalsIgnoreCase("admin") || eUsuarioValido && usuario.getGrupo().equalsIgnoreCase("estoquista")) {

            req.getSession().setAttribute("loggedUsuario", email);

            resp.sendRedirect("encontrar-todos-produtos");

        } else {

            req.setAttribute("message", "Credenciais Inválidas!");

            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }

    }

}
