package model;

public class Cliente {
    private String id;
    private String nome;
    private String email;
    private String DataNasimento;
    private String genero;
    private String cpf;
    private String senha;
    private String confirmaSenha;
    private String enderecoFaturamento;
    private String enderecoEntrega;

    public Cliente() {
    }

    public Cliente(String email, String senha, String confirmaSenha) {
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }



    public Cliente(String id, String nome, String email, String dataNasimento, String genero, String cpf, String senha, String confirmaSenha, String enderecoEntrega) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        DataNasimento = dataNasimento;
        this.genero = genero;
        this.cpf = cpf;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.enderecoEntrega = enderecoEntrega;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasimento() {return DataNasimento;}

    public void setDataNasimento(String dataNasimento) {DataNasimento = dataNasimento;}

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getEnderecoFaturamento() {
        return enderecoFaturamento;
    }

    public void setEnderecoFaturamento(String enderecoFaturamento) {
        this.enderecoFaturamento = enderecoFaturamento;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
