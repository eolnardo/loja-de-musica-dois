package servlet.produto;


import dao.ProdutoDAO;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/visualizar")
public class VisualizarProdutoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Produto produto = new ProdutoDAO().exibirProduto(id);

        req.setAttribute("produto", produto);

        req.getRequestDispatcher("produto.jsp").forward(req, resp);

    }
}
