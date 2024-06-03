package servlet.compra;

import dao.ClienteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String idCliente = "0";

        if (session.getAttribute("id") != null) {
            String sessionId = session.getAttribute("id").toString();
            if (!sessionId.isBlank() && !sessionId.equalsIgnoreCase("null")) {
                idCliente = sessionId;
            }
        }

        ClienteDAO clienteDao = new ClienteDAO();

        req.setAttribute("enderecos", clienteDao.encontrarEnderecoPorClienteId(idCliente));

        RequestDispatcher dispatcher = req.getRequestDispatcher("checkout.jsp");
        dispatcher.forward(req, resp);
    }
}
