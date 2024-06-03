package servlet.compra;

import dao.CarrinhoDAO;
import model.Carrinho;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adicionar-carrinho")
public class CriarCarrinhoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String idCliente = "0";

        if (session.getAttribute("id") != null) {
            String sessionId = session.getAttribute("id").toString();
            if (!sessionId.isBlank() && !sessionId.equalsIgnoreCase("null")) {
                idCliente = sessionId;
            }
        }

        String idProduto = req.getParameter("idProdutoCarrinho"); // Verifique o nome do parâmetro aqui
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        if (idProduto == null || idProduto.isEmpty()) {
            // Handle error or redirect to the product page
            resp.sendRedirect("/error-page.jsp");
            return;
        }

        CarrinhoDAO existeCarrinhoDao = new CarrinhoDAO();

        Carrinho existeCarrinho = existeCarrinhoDao.encontrarPorClienteIdeProdutoId(idCliente, idProduto);
        if (existeCarrinho != null) {
            int novaQuantidade = existeCarrinho.getQuantidade() + quantidade;
            //existeCarrinhoDao.updateCarrinho(existeCarrinho.getId(), novaQuantidade);
        } else {
            Carrinho carrinho = new Carrinho(idProduto, idCliente, quantidade);
            existeCarrinhoDao.criarCarrinho(carrinho);
        }

        resp.sendRedirect("/encontrar-carrinho?idCliente=" + idCliente);
    }
}
