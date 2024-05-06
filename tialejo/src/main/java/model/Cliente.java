package model;


public class Cliente {

    public enum Genero {
        MASCULINO,
        FEMININO,
        OUTRO
    }
    private String id;
    private String nome;
    private String email;
    private String nascimento;
    private Genero genero;
    private String endereco;
    private String cpf;
    private String senha;
    private String confirmarSenha;

    public Cliente() {
    }

    public Cliente(String id, String nome, String email, String nascimento, Genero genero, String endereco, String cpf, String senha, String confirmarSenha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.cpf = cpf;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }
}
