package servlet.cliente;

import dao.ClienteDAO;
import model.Cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/atualizar-cadastro-cliente")
public class AtualizarCadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cliente cliente = ClienteDAO.getCliente();

        System.out.println(cliente);

        req.setAttribute("cliente", cliente);

        req.getRequestDispatcher("perfil-cliente.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClienteDAO clienteDao = new ClienteDAO();

        String clienteNome = req.getParameter("nome");
        String clienteSenha = req.getParameter("senha");
        String clienteConfirmaSenha = req.getParameter("confirmaSenha");
        String clienteEnderecoFaturamento = req.getParameter("enderecoFaturamento");
        String clienteEnderecoEntrega = req.getParameter("enderecoEntrega");
        String clienteGenero = req.getParameter("genero");
        String clienteNascimento = req.getParameter("dataNascimento");
        String clienteId = req.getParameter("id");

        System.out.println(clienteNascimento);

        Cliente novoCliente = new Cliente(clienteNome, clienteGenero, clienteNascimento, clienteSenha, clienteConfirmaSenha, clienteEnderecoEntrega, clienteEnderecoFaturamento, clienteId);

        if (!clienteId.isBlank()) {
            System.out.println(novoCliente);
            clienteDao.atualizarCliente(novoCliente);
            System.out.println(novoCliente);
        }

        resp.sendRedirect("/carregar-tela-inicial");
    }


}


