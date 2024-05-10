package model;

public class Cliente {
    private String id;
    private String nome;
    private String email;
    private String dataNascimento;
    private String genero;
    private String cpf;
    private String senha;
    private String confirmaSenha;
    private String enderecoFaturamento;
    private String enderecoEntrega;
    private String cepFaturamento;
    private String cepEntrega;





    public Cliente(String nome, String genero, String dataNasimento, String senha, String confirmaSenha, String id) {
        this.nome = nome;
        dataNascimento = dataNasimento;
        this.genero = genero;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.id = id;
    }

    public Cliente(String nome, String genero, String dataNasimento, String id) {
        this.nome = nome;
        dataNascimento = dataNasimento;
        this.genero = genero;
        this.id = id;
    }

    public Cliente(String email, String senha, String confirmaSenha) {
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }

    public Cliente(String id, String nome, String email, String dataNasimento, String genero, String cpf, String senha, String confirmaSenha, String enderecoEntrega, String enderecoFaturamento, String cepEntrega, String cepFaturamento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        dataNascimento = dataNasimento;
        this.genero = genero;
        this.cpf = cpf;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoFaturamento = enderecoFaturamento;
        this.cepFaturamento = cepFaturamento;
        this.cepEntrega = cepEntrega;
    }


    public Cliente(String id, String nome, String email, String dataNasimento, String genero, String cpf, String senha, String confirmaSenha, String enderecoEntrega) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        dataNascimento = dataNasimento;
        this.genero = genero;
        this.cpf = cpf;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.enderecoEntrega = enderecoEntrega;
    }

    public Cliente(String id, String nome, String email, String dataNasimento, String genero, String cpf, String senha, String confirmaSenha, String enderecoEntrega, String enderecoFaturamento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        dataNascimento = dataNasimento;
        this.genero = genero;
        this.cpf = cpf;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoFaturamento = enderecoFaturamento;
    }

    public Cliente(String nome, String genero, String dataNasimento, String senha, String confirmaSenha, String enderecoEntrega, String enderecoFaturamento, String id) {
        this.id = id;
        this.nome = nome;
        dataNascimento = dataNasimento;
        this.genero = genero;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoFaturamento = enderecoFaturamento;

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

    public String getdataNascimento() {return dataNascimento;}

    public void setdataNascimento(String dataNasimento) {dataNascimento = dataNasimento;}

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

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCepFaturamento() {
        return cepFaturamento;
    }

    public void setCepFaturamento(String cepFaturamento) {
        this.cepFaturamento = cepFaturamento;
    }

    public String getCepEntrega() {
        return cepEntrega;
    }

    public void setCepEntrega(String cepEntrega) {
        this.cepEntrega = cepEntrega;
    }
}
