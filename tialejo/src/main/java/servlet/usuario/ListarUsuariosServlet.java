package servlet.usuario;


import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/encontrar-todos-usuarios")
public class ListarUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Usuario> usuarios = new UsuarioDAO().encontrarTodosUsuarios();

        req.setAttribute("usuarios", usuarios);

        req.getRequestDispatcher("listar-usuarios.jsp").forward(req, resp);

    }

}