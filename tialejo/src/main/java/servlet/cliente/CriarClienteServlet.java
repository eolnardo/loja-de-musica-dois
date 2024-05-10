package servlet.cliente;

import dao.ClienteDAO;
import model.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/criar-cliente")
public class CriarClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String clienteNome = req.getParameter("nome");
        System.out.println(clienteNome);
        String clienteEmail = req.getParameter("email");
        String clienteNascimento = req.getParameter("dataNascimento");
        String clienteGenero = req.getParameter("genero");
        String cepFaturamento = req.getParameter("cepFaturamento");
        String cepEntrega = req.getParameter("cepEntrega");
        String clientEnderecoFaturamento = consultarEnderecoPorCEP(cepEntrega);
        String clienteEnderecoEntrega = consultarEnderecoPorCEP(cepEntrega);
        String clienteCPF = req.getParameter("cpf");
        String clienteSenha = req.getParameter("senha");
        String clienteConfirmarSenha = req.getParameter("confirmarSenha");
        String clienteId = req.getParameter("id");

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente(clienteId, clienteNome, clienteEmail, clienteNascimento, clienteGenero, clienteCPF, clienteSenha , clienteConfirmarSenha, clienteEnderecoEntrega, clientEnderecoFaturamento, cepEntrega, cepFaturamento);

        if (clienteId == null || clienteId.isBlank()){
            clienteDAO.criarCliente(cliente);

            System.out.println(cliente);
            }else{
            clienteDAO.endereco(Integer.parseInt(cliente.getId()), cliente.getCepEntrega(), cliente.getEnderecoEntrega());
            clienteDAO.endereco(Integer.parseInt(cliente.getId()), cliente.getCepFaturamento(), cliente.getEnderecoFaturamento());
            clienteDAO.atualizarCliente(cliente);
        }

        resp.sendRedirect("/login-cliente");
    }

    private String consultarEnderecoPorCEP(String cep) {
        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            return jsonObject.getString("logradouro") + ", " + jsonObject.getString("bairro") + ", " +
                    jsonObject.getString("localidade") + " - " + jsonObject.getString("uf");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
