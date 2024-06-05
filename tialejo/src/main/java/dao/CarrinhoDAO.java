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

    private List<String> nomeProdutos = new ArrayList<>();

    public List<ItemPedido> passarCarrinho(List<Carrinho> carrinhos) {
        List<ItemPedido> itemPedidos = new ArrayList<>();
        int i = 0;

        for (Carrinho carrinho : carrinhos) {
            int idProduto = Integer.parseInt(carrinho.getIdProduto());
            System.out.println(nomeProdutos);

            String nomeProduto = "";
            if (!nomeProdutos.isEmpty() && nomeProdutos.size() > 0) {
                nomeProduto = nomeProdutos.get(0);
                System.out.println(nomeProduto);
            }

            int quantidadeProduto = carrinho.getQuantidade();
            BigDecimal valorUnitario = carrinho.getProduto().getPreco();

            ItemPedido itemPedido = new ItemPedido(idProduto, nomeProduto, quantidadeProduto, valorUnitario);
            itemPedidos.add(itemPedido);

            System.out.println(itemPedido);
            i++;
        }
        return itemPedidos;
    }

    public List<Carrinho> encontrarCarrinhoPorClienteId(String idCliente) {
        String SQL = "SELECT CARRINHO.IDCARRINHO, CARRINHO.IDCLIENTE, CARRINHO.IDPRODUTO, CARRINHO.QUANTIDADE, PRODUTO.NOME, PRODUTO.DESCRICAO, PRODUTO.PRECO, PRODUTO.IMAGE FROM CARRINHO INNER JOIN PRODUTO ON CARRINHO.IDPRODUTO = PRODUTO.ID WHERE CARRINHO.IDCLIENTE = ?";
        List<Carrinho> carrinhos = new ArrayList<>();

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, idCliente);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String produtoId = resultSet.getString("IDPRODUTO");
                    String clienteId = resultSet.getString("IDCLIENTE");
                    String produtoNome = resultSet.getString("NOME");
                    String produtoDescricao = resultSet.getString("DESCRICAO");
                    BigDecimal preco = resultSet.getBigDecimal("PRECO");
                    String imagemProduto = resultSet.getString("IMAGE");
                    int quantidade = resultSet.getInt("QUANTIDADE");

                    nomeProdutos.add(produtoNome);

                    Produto produto = new Produto(produtoId, produtoNome, produtoDescricao, preco, imagemProduto);
                    Carrinho carrinho = new Carrinho(resultSet.getString("IDCARRINHO"), produtoId, clienteId, quantidade, produto);
                    carrinhos.add(carrinho);
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
                    String idCarrinho = resultSet.getString("IDCARRINHO");
                    int quantidade = resultSet.getInt("QUANTIDADE");
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

    public void finalizarCarrinho(List<ItemPedido> itemPedidos, String idCliente) {
        String insertPedidoSQL = "INSERT INTO PEDIDO (idCliente, totalPedido, numeroItens, status, data, frete, endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String insertItemPedidoSQL = "INSERT INTO ITEMPEDIDO (idPedido, idProduto, quantidade, valorUnitario, nomeProduto) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionPoolConfig.getConnection()) {
            connection.setAutoCommit(false); // Inicia a transação

            int quantidadeTotal = 0;
            BigDecimal valorTotal = BigDecimal.valueOf(0.0);

            for (ItemPedido itemPedido : itemPedidos) {
                quantidadeTotal += itemPedido.getQuantidade();
                valorTotal = valorTotal.add(itemPedido.subTotalItemPedido());
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertPedidoSQL, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, idCliente);
                preparedStatement.setBigDecimal(2, valorTotal);
                preparedStatement.setInt(3, quantidadeTotal);
                preparedStatement.setString(4, "Aguardando Pagamento");
                preparedStatement.setString(5, "04/06/2024");
                preparedStatement.setBigDecimal(6, calcularFrete());
                preparedStatement.setString(7, getEnderecoEntrega(idCliente));
                preparedStatement.executeUpdate();

                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idPedido = generatedKeys.getInt(1);

                        try (PreparedStatement itemPreparedStatement = connection.prepareStatement(insertItemPedidoSQL)) {
                            for (ItemPedido itemPedido : itemPedidos) {
                                itemPreparedStatement.setInt(1, idPedido);
                                itemPreparedStatement.setInt(2, itemPedido.getIdProduto());
                                itemPreparedStatement.setInt(3, itemPedido.getQuantidade());
                                itemPreparedStatement.setBigDecimal(4, itemPedido.getValorUnitario());
                                itemPreparedStatement.setString(5, itemPedido.getNomeProduto());
                                itemPreparedStatement.addBatch();
                            }
                            itemPreparedStatement.executeBatch();
                        }
                    }
                }

                connection.commit(); // Comita a transação
            } catch (SQLException e) {
                connection.rollback(); // Rollback em caso de erro
                throw e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private BigDecimal calcularFrete() {
        return BigDecimal.valueOf(10.00); // Exemplo de valor fixo
    }

    private String getEnderecoEntrega(String clienteId) {
        return "Endereço de entrega do cliente"; // Exemplo de endereço fixo
    }

    public void removerProdutoCarrinho(Carrinho carrinho) {
        String SQL = "DELETE FROM CARRINHO WHERE IDPRODUTO = ? AND IDCLIENTE = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, carrinho.getIdProduto());
            preparedStatement.setString(2, carrinho.getIdCliente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }
}
