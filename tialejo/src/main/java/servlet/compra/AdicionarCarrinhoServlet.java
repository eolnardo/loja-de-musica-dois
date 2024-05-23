package servlet.compra;

import dao.ClienteDAO;
import dao.CarrinhoDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.Carrinho;
import model.ItemPedido;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/adicionar-carrinho")
public class AdicionarCarrinhoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obter o carrinho da sessão
        HttpSession session = req.getSession();
        List<ItemPedido> carrinho = (List<ItemPedido>) session.getAttribute("carrinho");

        // Verificar se o carrinho não é nulo
        if (carrinho == null) {
            // Se o carrinho for nulo, criar um novo
            carrinho = new ArrayList<>();
            session.setAttribute("carrinho", carrinho);
        }

        System.out.println(carrinho);

        // Se o carrinho não estiver vazio, obter os detalhes dos produtos no carrinho
        List<Produto> produtosCarrinho = new CarrinhoDAO().mostrarCarrinho(carrinho);

        System.out.println(produtosCarrinho.toString());

        // Definir os produtos do carrinho como um atributo para serem exibidos na página JSP
        req.setAttribute("produtosCarrinho", produtosCarrinho);

        // Encaminhar para a página do carrinho
        req.getRequestDispatcher("carrinho.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obter a sessão atual do usuário
        HttpSession session = req.getSession();

        // Obter o carrinho da sessão
        List<ItemPedido> carrinho = (List<ItemPedido>) session.getAttribute("carrinho");
        if (carrinho == null) {
            // Se o carrinho não existir na sessão, criar um novo
            carrinho = new ArrayList<>();
            session.setAttribute("carrinho", carrinho);
        }

        // Adicionar o item ao carrinho
        String nomeProduto = req.getParameter("nome");
        BigDecimal precoProduto = new BigDecimal(req.getParameter("preco"));
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setNomeProduto(nomeProduto);
        itemPedido.setValorUnitario(precoProduto);
        itemPedido.setQuantidade(1); // Definir a quantidade como 1 por padrão
        carrinho.add(itemPedido);

        // Redirecionar para a página do carrinho
        resp.sendRedirect("/carrinho.jsp");
    }
}

