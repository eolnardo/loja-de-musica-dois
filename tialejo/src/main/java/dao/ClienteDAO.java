package dao;

import model.Carrinho;
import model.Cliente;
import model.Endereco;
import model.Produto;
import servlet.config.ConnectionPoolConfig;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    static private Cliente clienteEstatico;

    public boolean verificarCredenciais(Cliente cliente) {

        String SQL = "SELECT * FROM Cliente WHERE email = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("success in select email");

            while (resultSet.next()) {

                String senha = resultSet.getString("senha");
                String confirmaSenha = resultSet.getString("confirmaSenha");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String enderecoFaturamento = resultSet.getString("enderecoFaturamento");
                String enderecoEntrega = resultSet.getString("enderecoEntrega");
                String genero = resultSet.getString("genero");
                String id = resultSet.getString("id");
                String dataNascimento = resultSet.getString("dataNascimento");

                Cliente clienteAtual = new Cliente(id, nome, cliente.getEmail(), dataNascimento, genero, cpf, senha, confirmaSenha, enderecoEntrega, enderecoFaturamento);

                setCliente(clienteAtual);

                if (senha.equals(cliente.getSenha()) && confirmaSenha.equals(cliente.getConfirmaSenha())) {


                    System.out.println(cliente.getNome() + cliente.getId());

                    return true;

                }

            }

            connection.close();

            return false;

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

            return false;

        }

    }

    public void criarCliente(Cliente cliente) {

        String SQL = "INSERT INTO Cliente (nome, email, datanascimento, genero, enderecoEntrega, enderecoFaturamento, cpf, senha, confirmaSenha, cepEntrega, cepFaturamento) VALUES ( ?, ?, ?, ?, ?, ?,?,?,?,?,?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getdataNascimento());
            preparedStatement.setString(4, cliente.getGenero());
            preparedStatement.setString(5, cliente.getEnderecoEntrega());
            preparedStatement.setString(6, cliente.getEnderecoFaturamento());
            preparedStatement.setString(7, cliente.getCpf());
            preparedStatement.setString(8, cliente.getSenha());
            preparedStatement.setString(9, cliente.getConfirmaSenha());
            preparedStatement.setString(10, cliente.getCepEntrega());
            preparedStatement.setString(11, cliente.getCepFaturamento());


            preparedStatement.execute();
            connection.close();

        } catch (SQLException e) {
            System.out.println("fail in database connection 1");
            throw new RuntimeException(e);
        }
    }

    public void atualizarCliente(Cliente cliente) {

        String SQL = "UPDATE CLIENTE SET NOME = ?, SENHA = ?, CONFIRMASENHA = ?, DATANASCIMENTO = ?, GENERO = ? WHERE email = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSenha());
            preparedStatement.setString(3, cliente.getConfirmaSenha());
            preparedStatement.setString(4, cliente.getdataNascimento());
            preparedStatement.setString(5, cliente.getGenero());
            preparedStatement.setString(6, cliente.getId());
            preparedStatement.execute();

            System.out.println("success in atualizar cadastro cliente");

            connection.close();

        } catch (SQLException e) {

            System.out.println("fail in database connection 6");
            System.out.println("Error: " + e.getMessage());

        }

    }

    public void endereco(int id, String cep, String endereco) {
        String SQL = "INSERT INTO Endereco (ClienteID, Endereco, CEP) VALUES (?, ?, ?)";
        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, endereco);
            preparedStatement.setString(3, cep);
            preparedStatement.execute();

            System.out.println("success in salvar endereco cliente");

            connection.close();

        } catch (SQLException e) {

            System.out.println("fail in database connection 6");
            System.out.println("Error: " + e.getMessage());

        }

    }

    public List<Endereco> encontrarEnderecoPorClienteId (String id){

        String SQL = "SELECT * FROM ENDERECO WHERE IDCLIENTE = ?";

        List<Endereco> enderecos = new ArrayList<>();

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("estou aqui 2c");
                while (resultSet.next()) {
                    String enderecoId = resultSet.getString("id");
                    String enderecoCep = resultSet.getString("cep");
                    String endereco = resultSet.getString("endereco");
                    String enederecoClienteId = resultSet.getString("idCliente");
                    System.out.println("estou aqui 133c");
                    System.out.println(enderecoId);

                    Endereco novoEndereco = new Endereco(enderecoId, enederecoClienteId, endereco, enderecoCep);

                    enderecos.add(novoEndereco);
                }
            }

            System.out.println("sucesso em consultar endereços do cliente");

            connection.close();

        } catch (SQLException e) {

            System.out.println("fail in database connection 17");
            System.out.println("Error: " + e.getMessage());

        }

        return enderecos;
    }

//    public Cliente encontrarClientePorId(String id) {
//        String SQL = "SELECT * FROM CLIENTE WHERE id = ?";
//
//        Cliente cliente = null;
//
//        try {
//
//            Connection connection = ConnectionPoolConfig.getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
//            preparedStatement.setString(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            System.out.println(resultSet.getString("nome"));
//
//            System.out.println("success in select email");
//
//
//            while (resultSet.next()) { // Verifica se há uma linha no resultado
//
//                cliente.setNome(resultSet.getString("nome"));
//                cliente.setGenero(resultSet.getString("genero"));
//                cliente.setDataNasimento(resultSet.getString("dataNascimento"));
//                cliente.setCpf(resultSet.getString("cpf"));
//                cliente.setEnderecoEntrega(resultSet.getString("enderecoEntrega"));
//                cliente.setEnderecoFaturamento(resultSet.getString("enderecoFaturamento"));
//                cliente.setSenha(resultSet.getString("senha"));
//                cliente.setConfirmaSenha(resultSet.getString("confirmaSenha"));
//                cliente.setId(resultSet.getString("id"));
//
//            }
//
//            System.out.println(cliente);
//
//            connection.close();
//
//            return cliente;
//
//        } catch (Exception e) {
//
//            System.out.println("Error: " + e.getMessage());
//
//            cliente = null;
//            return cliente;
//        }
//    }

    public static Cliente getCliente() {
        return clienteEstatico;
    }

    public static void setCliente(Cliente cliente) {
        clienteEstatico = cliente;
    }
}