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

    String email2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cliente cliente = new ClienteDAO().encontrarClientePorId();

        System.out.println(cliente);


        req.setAttribute("cliente", cliente);

        req.getRequestDispatcher("perfil-cliente.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sessao = req.getSession().getAttribute("loggedCliente").toString();

        System.out.println(sessao);

        Cliente cliente = new ClienteDAO().encontrarClientePorId();

        ClienteDAO clienteDao = new ClienteDAO();

        System.out.println(cliente);

        String clienteNome = cliente.getNome();
        String clienteGenero = cliente.getGenero();
        String clienteNascimento = cliente.getDataNasimento();
        String clienteSenha = cliente.getSenha();
        String clienteConfirmaSenha = cliente.getConfirmaSenha();
        String clienteId = cliente.getId();

        System.out.println(clienteNascimento);

        Cliente novoCliente = new Cliente(clienteNome, clienteGenero, clienteNascimento, clienteSenha, clienteConfirmaSenha, clienteId);

        if (!clienteId.isBlank()) {
            System.out.println(novoCliente);
            clienteDao.atualizarCliente(novoCliente);
            System.out.println(novoCliente);
        }

        resp.sendRedirect("/carregar-tela-inicial");
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email) {
        this.email2 = email;
    }
}


