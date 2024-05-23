package servlet.compra;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class CompraServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupere o ID do produto do parâmetro da solicitação
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));

        // Recupere ou crie o carrinho do usuário (armazenado na sessão)
        HttpSession session = request.getSession(true);
        Pedido carrinho = (Pedido) session.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new Pedido();
            session.setAttribute("carrinho", carrinho);
        }

        // Verifique se o produto já está no carrinho
        boolean produtoExistente = false;
        for (ItemPedido item : carrinho.getListaItens()) {
            if (item.getIdProduto() == idProduto) {
                // Se o produto já está no carrinho, aumente a quantidade
                item.setQuantidade(item.getQuantidade() + 1);
                produtoExistente = true;
                break;
            }
        }

        // Se o produto não estiver no carrinho, adicione-o com quantidade 1
        if (!produtoExistente) {
            ItemPedido novoItem = new ItemPedido();
            novoItem.setIdProduto(idProduto);
            novoItem.setQuantidade(1);
            // Defina o valorUnitario do novoItem com base no banco de dados, se necessário
            carrinho.getListaItens().add(novoItem);
        }

        // Redirecione de volta para a página inicial ou para o carrinho
        response.sendRedirect("index.jsp"); // Você pode mudar para a página do carrinho se preferir
    }
}

