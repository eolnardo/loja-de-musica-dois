package dao;

import model.Carrinho;
import model.ItemPedido;
import model.Produto;
import servlet.config.ConnectionPoolConfig;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {

    public List<Carrinho> encontrarCarrinhoPorClienteId(String idCliente) {
        String SQL = "SELECT  CARRINHO.IDCARRINHO,  CARRINHO.IDCLIENTE,  CARRINHO.IDPRODUTO,  CARRINHO.QUANTIDADE, PRODUTO.NOME, PRODUTO.DESCRICAO, PRODUTO.PRECO, PRODUTO.IMAGE FROM  CARRINHO INNER JOIN PRODUTO ON  CARRINHO.IDPRODUTO = PRODUTO.ID WHERE  CARRINHO.IDCLIENTE = ?";


        System.out.println("estou aqui");

        List<Carrinho> carrinhos = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, idCliente);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("estou aqui 1c");
                while (resultSet.next()) {
                    String produtoId = resultSet.getString("idProduto");
                    String clienteId = resultSet.getString("idCliente");
                    String produtoNome = resultSet.getString("nome");
                    String produtoDescricao = resultSet.getString("descricao");
                    BigDecimal preco = resultSet.getBigDecimal("preco");
                    String imagemProduto = resultSet.getString("image");
                    int quantidade = resultSet.getInt("quantidade");
                    System.out.println("estou aqui 122c");

                    Produto produto = new Produto(produtoId, produtoNome, produtoDescricao, preco, imagemProduto);
                    System.out.println(produtoId);
                    Carrinho carrinho = new Carrinho(resultSet.getString("IDCARRINHO"), produtoId, clienteId, quantidade, produto);

                    System.out.println(produto);
                    System.out.println(carrinho);
                    System.out.println(produtoId);

                    carrinhos.add(carrinho);

                    System.out.println(carrinho);

                }
            }

        } catch (Exception e) {
            System.out.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
        return carrinhos;
    }

    public Carrinho encontrarPorClienteIdeProdutoId(String idCliente, String idProduto) {
        String SQL = "SELECT * FROM CARRINHO WHERE IDCLIENTE = ? AND IDPRODUTO = ?";
        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, idCliente);
            preparedStatement.setString(2, idProduto);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String idCarrinho = resultSet.getString("idCarrinho");
                    int quantidade = resultSet.getInt("quantidade");
                    return new Carrinho(idCarrinho, idProduto, idCliente, quantidade);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
        return null;
    }
    public void criarCarrinho(Carrinho carrinho) {
        String SQL = "INSERT INTO CARRINHO (idCliente, idProduto, quantidade) VALUES (?, ?, ?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carrinho.getIdCliente());
            preparedStatement.setString(2, carrinho.getIdProduto());
            preparedStatement.setInt(3, carrinho.getQuantidade());

            preparedStatement.execute();
            System.out.println("success in insert command");
            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir na tabela CARRINHO: " + e.getMessage());
        }
    }

    public void removerProdutoCarrinho(Carrinho carrinho){

    }
}
