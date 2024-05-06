package model;

public class Usuario {
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private String grupo;
    private boolean status;
    private String senha;
    private String confirmaSenha;

    public Usuario() {
    }

    public Usuario(String id, String nome, String email, String grupo, String cpf, String senha, String confirmaSenha, boolean status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.grupo = grupo;
        this.status = status;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }

    public Usuario(String email, String grupo, String senha, String confirmaSenha) {
        this.email = email;
        this.grupo = grupo;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }

    public Usuario(String nome, String email, boolean status, String grupo) {
        this.nome = nome;
        this.email = email;
        this.status = status;
        this.grupo = grupo;
    }

    public Usuario(String email, String senha, String confirmaSenha) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                "id='" + id + '\'' +
                ", grupo='" + grupo + '\'' +
                ", status=" + status +
                ", senha='" + senha + '\'' +
                ", confirmaSenha='" + confirmaSenha + '\'' +
                '}';
    }
}
