package dao;

import model.Cliente;
import servlet.config.ConnectionPoolConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void criarCliente(Cliente cliente){

        String SQL = "INSERT INTO Cliente (nome, email, nascimento, genero, endereco, cpf, senha, confirmarSenha) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        try{

            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getNascimento());
            preparedStatement.setString(4, cliente.getGenero().name());
            preparedStatement.setString(5, cliente.getEndereco());
            preparedStatement.setString(6, cliente.getCpf());
            preparedStatement.setString(7, cliente.getSenha());
            preparedStatement.setString(8, cliente.getConfirmarSenha());

            preparedStatement.execute();

            connection.close();

        } catch (SQLException e) {
            System.out.println("fail in database connection 1");
            throw new RuntimeException(e);
        }
    }
}
