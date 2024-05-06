package dao;

import model.Usuario;
import model.Usuario;
import servlet.config.ConnectionPoolConfig;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                usuario.setGrupo(resultSet.getString("grupo"));
                usuario.setId(resultSet.getString("id"));


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

    public List<Usuario> encontrarTodosUsuarios() {

        String SQL = "SELECT * FROM USUARIO";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();

            while (resultSet.next()) {

                String usuarioNome = resultSet.getString("nome");
                String usuarioEmail = resultSet.getString("email");
                boolean usuarioStatus = resultSet.getBoolean("status");
                String usuarioGrupo = resultSet.getString("grupo");

                Usuario usuario = new Usuario(usuarioNome, usuarioEmail, usuarioStatus, usuarioGrupo);

                usuarios.add(usuario);

            }


            System.out.println("success in select * usuario");

            connection.close();

            return usuarios;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }

    public Usuario encontrarUsuarioPorId(int id) {
        String SQL = "SELECT * FROM Usuario WHERE id = ?";
        Usuario usuario = null;

        try (
                Connection connection = ConnectionPoolConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SQL)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getString("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("email"),
                        resultSet.getString("grupo"),
                        resultSet.getString("cpf"),
                        resultSet.getString("senha"),
                        resultSet.getString("confirmaSenha"),
                        resultSet.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao encontrar usuário por ID", e);
        }

        return usuario;
    }

    public void atualizarStatusUsuario(Usuario produto) {
        String SQL = "UPDATE Usuario SET status = ? WHERE id = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setBoolean(1, produto.isStatus());
            preparedStatement.setString(2, produto.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto", e);
        }
    }
}
