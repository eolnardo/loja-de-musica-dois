package model;

public class Endereco {

    String id;
    String clienteId;
    String endereco;
    String cep;

    public Endereco(String id, String clienteId, String endereco, String cep) {
        this.id = id;
        this.clienteId = clienteId;
        this.endereco = endereco;
        this.cep = cep;
    }

    public Endereco(String clienteId, String endereco, String cep) {
        this.clienteId = clienteId;
        this.endereco = endereco;
        this.cep = cep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
