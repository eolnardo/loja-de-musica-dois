package servlet.compra;

import dao.CarrinhoDAO;
import model.Carrinho;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adicionar-carrinho")
public class CriarCarrinhoServlet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String idCliente = req.getSession().getAttribute("id").toString();
            String idProduto = req.getParameter("id");
            int quantidade = Integer.parseInt(req.getParameter("quantidade"));
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
