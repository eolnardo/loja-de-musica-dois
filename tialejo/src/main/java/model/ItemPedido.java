package model;

import java.math.BigDecimal;

public class ItemPedido {

    int idItemPedido;
    int idPedido;
    int numeroItens;
    int idProduto;
    int quantidade;
    BigDecimal valorUnitario;
    String nomeProduto;

    public ItemPedido(int idProduto, String nomeProduto, int quantidadeProduto, BigDecimal valorUnitario){
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidadeProduto;
        this.valorUnitario = valorUnitario;
    }

    public ItemPedido(int quantidade, BigDecimal valorUnitario, String nomeProduto) {
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.nomeProduto = nomeProduto;
    }

    public int getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumeroItens() {
        return numeroItens;
    }

    public void setNumeroItens(int numeroItens) {
        this.numeroItens = numeroItens;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal subTotalItemPedido(){
        if (this.valorUnitario != null) {
            return this.valorUnitario.multiply(BigDecimal.valueOf(this.quantidade));
        } else {
            System.out.println("Valor unitário nulo para o produto: " + this.nomeProduto);
            return BigDecimal.ZERO;
        }
    }
}
