package br.com.autosafe.autosafeapp.domain;

import java.io.Serializable;

/**
 * Created by François on 3/24/2016.
 */
public class Login implements Serializable {

    private String cpf;
    private String senha;
    private Cliente cliente;


    public Login(String cpf, String senha, Cliente cliente) {
        this.cpf = cpf;
        this.senha = senha;
        this.cliente = cliente;
    }

    public Login() {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Login{" +
                "cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
