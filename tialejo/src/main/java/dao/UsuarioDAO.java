package dao;

import model.Usuario;
import servlet.config.ConnectionPoolConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    public boolean verificarCredenciais(Usuario usuario) {

        String SQL = "SELECT * FROM Usuario WHERE email = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuario.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("success in select email");

            while (resultSet.next()) {

                String senha = resultSet.getString("senha");
                String confirmaSenha = resultSet.getString("senha");

                if (senha.equals(usuario.getSenha()) && confirmaSenha.equals(usuario.getConfirmaSenha())) {

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
}
