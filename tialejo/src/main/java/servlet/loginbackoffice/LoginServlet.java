package servlet.loginbackoffice;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login-backoffice")
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

        System.out.println(usuario);

        boolean eUsuarioValido = new UsuarioDAO().verificarCredenciais(usuario);

        if (eUsuarioValido) {

            req.getSession().setAttribute("loggedUsuario", email);
            req.getSession().setAttribute("grupo", usuario.getGrupo());

            if (usuario.getGrupo().equalsIgnoreCase("administrador")){
                req.getSession().setAttribute("grupo", "admin");
                resp.sendRedirect("administrador.jsp");
            }
            else if (usuario.getGrupo().equalsIgnoreCase("estoquista")) resp.sendRedirect("estoquista.jsp");

        } else {

            req.setAttribute("message", "Credenciais Inválidas!");

            req.getRequestDispatcher("backoffice.jsp").forward(req, resp);

        }

    }

}
