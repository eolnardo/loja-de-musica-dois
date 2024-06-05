package model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Carrinho {
    private String idCarrinho;
    private String idCliente;
    private String idProduto;
    private BigDecimal valorUnitario;
    private int quantidade;
    private String data;
    private ArrayList<ItemPedido> listaItens;
    private BigDecimal frete;
    private String endereco;
    private Produto produto;

    public Carrinho() {
    }

    public Carrinho(String idCarrinho, String idProduto, String idCliente, int quantidade, Produto produto) {
        this.idCarrinho = idCarrinho;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.quantidade = quantidade;
        this.produto = produto;

    }

    public Carrinho( String idProduto, String idCliente, int quantidade) {
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Carrinho(String idCarrinho, String idCliente, String idProduto, int quantidade) {
        this.idCarrinho = idCarrinho;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getNumeroItens() {
        return quantidade;
    }

    public void setNumeroItens(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<ItemPedido> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<ItemPedido> listaItens) {
        this.listaItens = listaItens;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void calcularValorUnitario() {
        valorUnitario = BigDecimal.ZERO;
        quantidade = 0;
        for (ItemPedido item : listaItens) {
            valorUnitario = valorUnitario.add(item.subTotalItemPedido());
            quantidade += item.getQuantidade();
        }
        if (frete != null) {
            valorUnitario = valorUnitario.add(frete);
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(String idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Produto getProduto() {return produto;}

    @Override
    public String toString() {
        return "Carrinho{" +
                "idCarrinho='" + idCarrinho + '\'' +
                ", idCliente='" + idCliente + '\'' +
                ", idProduto='" + idProduto + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                ", data='" + data + '\'' +
                ", listaItens=" + listaItens +
                ", frete=" + frete +
                ", endereco='" + endereco + '\'' +
                ", produto=" + produto +
                '}';
    }
}
