package model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Pedido {

    int idPedido;
    int idCliente;
    BigDecimal totalPedido;
    int numeroItens;
    String data;
    ArrayList<ItemPedido> listaItens;
    BigDecimal frete;
    String endereco;

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
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

    public void calcularTotalPedido() {
        totalPedido = BigDecimal.ZERO;
        numeroItens = 0;
        for (ItemPedido item : listaItens) {
            totalPedido = totalPedido.add(item.subTotalItemPedido());
            numeroItens += item.getQuantidade();
        }
        if (frete != null) {
            totalPedido = totalPedido.add(frete);
        }
    }
}
