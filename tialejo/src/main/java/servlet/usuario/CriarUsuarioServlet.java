package servlet.usuario;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class CriarUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usuarioNome = req.getParameter("nome");
        System.out.println("Nome do usuario é: " + usuarioNome);
        String usuarioCpf = req.getParameter("cpf");
        String usuarioEmail = req.getParameter("email");
        String usuarioSenha = req.getParameter("senha");
        System.out.println(usuarioSenha);
        String usuarioConfirmaSenha = req.getParameter("confirmaSenha");
        String usuarioGrupo = req.getParameter("grupo");
        boolean usuarioStatus = true;
        String usuarioId = req.getParameter("id");

        UsuarioDAO usuarioDao = new UsuarioDAO();

        System.out.println(usuarioSenha);

        Usuario usuario = new Usuario(usuarioId, usuarioNome, usuarioEmail, usuarioGrupo, usuarioCpf, usuarioSenha, usuarioConfirmaSenha, usuarioStatus);

        System.out.println("oi");

        if (usuarioId == null || usuarioId.isBlank()) {
            System.out.println(usuario);
            usuarioDao.criarUsuario(usuario);
        } else {
            //usuarioDao.atualizarUsuario(usuario);
        }

        System.out.println("tchau");

        resp.sendRedirect("encontrar-todos-usuarios");
    }
}
