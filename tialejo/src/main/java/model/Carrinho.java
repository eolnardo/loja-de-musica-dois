package model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Carrinho {
    int idCarrinho;
    int idCliente;
    BigDecimal totalCarrinho;
    int numeroItens;
    String data;
    ArrayList<ItemPedido> listaItens;
    BigDecimal frete;
    String endereco;

    public Carrinho() {
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getTotalCarrinho() {
        return totalCarrinho;
    }

    public void setTotalCarrinho(BigDecimal totalCarrinho) {
        this.totalCarrinho = totalCarrinho;
    }

    public int getNumeroItens() {
        return numeroItens;
    }

    public void setNumeroItens(int numeroItens) {
        this.numeroItens = numeroItens;
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

    public void calcularTotalCarrinho() {
        totalCarrinho = BigDecimal.ZERO;
        numeroItens = 0;
        for (ItemPedido item : listaItens) {
            totalCarrinho = totalCarrinho.add(item.subTotalItemPedido());
            numeroItens += item.getQuantidade();
        }
        if (frete != null) {
            totalCarrinho = totalCarrinho.add(frete);
        }
    }
}
