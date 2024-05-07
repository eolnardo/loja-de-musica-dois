package model;

import java.math.BigDecimal;

public class Produto {

    private String id;
    private String nome;
    private String avaliacao;
    private String descricao;
    private BigDecimal preco;
    private int qtdEstoque;
    private boolean status;
    private String image;

    public Produto(String id, String nome, int qtdEstoque, BigDecimal preco, boolean status, String image) {
        this.id = id;
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.status = status;
        this.image = image;
    }

    public Produto(String id, String nome, String avaliacao, String descricao, BigDecimal preco, int qtdEstoque, boolean status, String image) {
        this.id = id;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.status = status;
        this.image = image;
    }

    public Produto(String id, String nome, int qtdEstoque, BigDecimal preco, boolean status) {
        this.id = id;
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
