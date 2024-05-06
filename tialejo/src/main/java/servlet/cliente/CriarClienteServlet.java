package servlet.cliente;

import dao.ClienteDAO;
import model.Cliente;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro-cliente")
public class CriarClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String clienteNome = req.getParameter("nome");
        System.out.println(clienteNome);
        String clienteEmail = req.getParameter("email");
        String clienteNascimento = req.getParameter("nascimento");

        String clienteGeneroString = req.getParameter("genero");
        Cliente.Genero clienteGenero = Cliente.Genero.valueOf(clienteGeneroString.toUpperCase());

        String clienteEndereco = req.getParameter("endereco");
        String clienteCPF = req.getParameter("cpf");
        String clienteSenha = req.getParameter("senha");
        String clienteConfirmarSenha = req.getParameter("confirmarSenha");
        String clienteId = req.getParameter("clienteId");

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente(clienteId, clienteNome, clienteEmail,clienteNascimento,clienteGenero, clienteEndereco, clienteCPF, clienteSenha, clienteConfirmarSenha);

        if (clienteId == null || clienteId.isBlank()){
            System.out.println(cliente);
            clienteDAO.criarCliente(cliente);
        }
    }
}
