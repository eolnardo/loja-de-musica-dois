package dao;

import model.Cliente;
import servlet.config.ConnectionPoolConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
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

     public void criarCliente(Cliente cliente){

        String SQL = "INSERT INTO Cliente (nome, email, nascimento, genero, endereco, cpf, senha, confirmarSenha) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        try{

            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getDataNasimento());
            preparedStatement.setString(4, cliente.getGenero());
            preparedStatement.setString(5, cliente.getEnderecoEntrega());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setString(7, cliente.getSenha());
            preparedStatement.setString(8, cliente.getConfirmaSenha());

            preparedStatement.execute();

            connection.close();

        } catch (SQLException e) {
            System.out.println("fail in database connection 1");
            throw new RuntimeException(e);
        }
    }


}
