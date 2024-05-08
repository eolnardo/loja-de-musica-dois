package servlet.logincliente;

import dao.ClienteDAO;
import model.Cliente;

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

        Cliente cliente = new Cliente(email, senha, confirmaSenha);

        System.out.println(grupo);

        boolean eClienteValido = new ClienteDAO().verificarCredenciais(cliente);

        if (eClienteValido) {

            req.getSession().setAttribute("loggedCliente", email);

            resp.sendRedirect("/carregar-tela-inicial");

        } else {

            req.setAttribute("message", "Credenciais Inválidas!");

            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }

    }

}
