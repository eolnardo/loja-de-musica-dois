package dao;

import model.ItemPedido;
import model.Produto;
import servlet.config.ConnectionPoolConfig;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {
    public void adicionarItemAoCarrinho(ItemPedido itemPedido) {
        String SQL = "INSERT INTO ItemPedido (idPedido, idProduto, quantidade, valorUnitario, nome) VALUES (?, ?, ?, ?, ?)";

        BigDecimal total;

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, itemPedido.getIdPedido());
            preparedStatement.setInt(2, itemPedido.getIdProduto());
            preparedStatement.setInt(3, itemPedido.getQuantidade());
            preparedStatement.setBigDecimal(4, itemPedido.subTotalItemPedido());
            preparedStatement.setString(5, itemPedido.getNomeProduto());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar item ao carrinho", e);
        }
    }

    public void aumentarQuantidadeItemNoCarrinho(int idItemPedido, int quantidade) {
        String SQL = "UPDATE ItemPedido SET quantidade = quantidade + ?, subtotal = preco * (quantidade + ?) WHERE idItemPedido = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setInt(2, quantidade);
            preparedStatement.setInt(3, idItemPedido);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao aumentar quantidade do item no carrinho", e);
        }
    }

    public void diminuirQuantidadeItemNoCarrinho(int idItemPedido, int quantidade) {
        String SQL = "UPDATE ItemPedido SET quantidade = quantidade - ?, subtotal = preco * (quantidade - ?) WHERE idItemPedido = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setInt(2, quantidade);
            preparedStatement.setInt(3, idItemPedido);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao diminuir quantidade do item no carrinho", e);
        }
    }

    public void removerItemDoCarrinho(int idItemPedido) {
        String SQL = "DELETE FROM ItemPedido WHERE idItemPedido = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idItemPedido);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover item do carrinho", e);
        }
    }

    public List<Produto> mostrarCarrinho(List<ItemPedido> carrinho) {
        List<Produto> produtosCarrinho = new ArrayList<>();

        // Verificar se o carrinho está vazio
        if (carrinho.isEmpty()) {
            return produtosCarrinho;
        }

        // Preparar a consulta SQL para obter os detalhes dos produtos no carrinho
        StringBuilder query = new StringBuilder("SELECT * FROM Produto WHERE idProduto IN (");
        for (int i = 0; i < carrinho.size(); i++) {
            query.append("?");
            if (i < carrinho.size() - 1) {
                query.append(",");
            }
        }
        query.append(")");

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {

            // Definir os parâmetros da consulta
            for (int i = 0; i < carrinho.size(); i++) {
                preparedStatement.setInt(i + 1, carrinho.get(i).getIdProduto());
            }

            // Executar a consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Processar os resultados da consulta
            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getString("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setPreco(resultSet.getBigDecimal("preco"));
                // Adicionar o produto à lista de produtos do carrinho
                produtosCarrinho.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter produtos do carrinho", e);
        }

        return produtosCarrinho;
    }

}
