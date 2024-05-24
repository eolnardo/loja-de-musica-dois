package servlet.compra;

import dao.CarrinhoDAO;
import model.Carrinho;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/encontrar-carrinho")
public class ExibirCarrinhoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //pega a categoria que o usuário selecionou na páagina web
        String idClienteStr = req.getParameter("idCliente");

        //transforma em inteiro
        String idCliente = idClienteStr;

        /*EnderecoDao enderecoDao = new EnderecoDao();
        List<Endereco> enderecosUsuario = enderecoDao.findEndereco(idCliente);
        req.setAttribute("enderecos", enderecosUsuario);
        // cria uma nova instância da DAO*/
        CarrinhoDAO carrinhoDao = new CarrinhoDAO();

        // chama o método findAllCategoria que devolve uma lista de Produto
        List<Carrinho> encontrarCarrinhoPorClienteId = carrinhoDao.encontrarCarrinhoPorClienteId(idCliente);

        // coloca uma varíavel para ser acessada na página web cujo o nome da variável é categorias
        req.setAttribute("carrinhos", encontrarCarrinhoPorClienteId);

        // aqui é defindo para qual página o usuário será direcionado
        req.getRequestDispatcher("/carrinho.jsp").forward(req, resp);



    }
}
