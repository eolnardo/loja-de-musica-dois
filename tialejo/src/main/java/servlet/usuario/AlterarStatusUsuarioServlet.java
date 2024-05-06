package servlet.usuario;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alterar-status-usuario")
public class AlterarStatusUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario usuario = usuarioDAO.encontrarUsuarioPorId(Integer.parseInt(id));

        usuario.setStatus(!usuario.isStatus());

        usuarioDAO.atualizarStatusUsuario(usuario);

        resp.sendRedirect("encontrar-todos-usuarios");
    }
}