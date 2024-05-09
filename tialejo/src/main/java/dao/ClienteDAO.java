package dao;

import model.Cliente;
import servlet.config.ConnectionPoolConfig;

import java.sql.*;

public class ClienteDAO {

    static String id;

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
                String confirmaSenha = resultSet.getString("senha");
                cliente.setNome(resultSet.getString("nome"));
                cliente.setId(resultSet.getString("id"));

                setId(resultSet.getString("id"));

                if (senha.equals(cliente.getSenha()) && confirmaSenha.equals(cliente.getConfirmaSenha())) {
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

        String SQL = "INSERT INTO Cliente (nome, email, datanascimento, genero, enderecoEntrega, enderecoFaturamento, cpf, senha, confirmaSenha, telefone) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getDataNasimento());
            preparedStatement.setString(4, cliente.getGenero());
            preparedStatement.setString(5, cliente.getEnderecoEntrega());
            preparedStatement.setString(6, cliente.getEnderecoFaturamento());
            preparedStatement.setString(7, cliente.getCpf());
            preparedStatement.setString(8, cliente.getSenha());
            preparedStatement.setString(9, cliente.getConfirmaSenha());
            preparedStatement.setString(10, cliente.getConfirmaSenha());

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
            preparedStatement.setString(4, cliente.getDataNasimento());
            preparedStatement.setString(5, cliente.getGenero());
            preparedStatement.setString(6, getId());
            preparedStatement.execute();

            System.out.println("success in atualizar cadastro cliente");

            connection.close();

        } catch (SQLException e) {

            System.out.println("fail in database connection 6");
            System.out.println("Error: " + e.getMessage());

        }

    }

    public Cliente encontrarClientePorId() {
        String SQL = "SELECT * FROM CLIENTE WHERE id = ?";

        Cliente cliente = null;

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet.getString("nome"));

            System.out.println("success in select email");


            while (resultSet.next()) { // Verifica se há uma linha no resultado

                cliente.setNome(resultSet.getString("nome"));
                cliente.setGenero(resultSet.getString("genero"));
                cliente.setDataNasimento(resultSet.getString("dataNascimento"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setEnderecoEntrega(resultSet.getString("enderecoEntrega"));
                cliente.setEnderecoFaturamento(resultSet.getString("enderecoFaturamento"));
                cliente.setSenha(resultSet.getString("senha"));
                cliente.setConfirmaSenha(resultSet.getString("confirmaSenha"));
                cliente.setId(resultSet.getString("id"));

            }

            System.out.println(cliente);

            connection.close();

            return cliente;

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

            cliente = null;
            return cliente;
        }
    }

    static public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}