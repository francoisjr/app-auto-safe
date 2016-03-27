package br.com.autosafe.autosafeapp.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by François on 3/19/2016.
 */
public class Apolice implements Serializable {

    private String id;
    private String dataValidade;
    private String localdaPernoite;
    private String descricaoUsoVeiculo;
    private Veiculo veiculo;
    private List<Cliente> clientes;

    public Apolice(String id, String dataValidade, String localdaPernoite, String descricaoUsoVeiculo, Veiculo veiculo, List<Cliente> clientes) {
        this.id = id;
        this.dataValidade = dataValidade;
        this.localdaPernoite = localdaPernoite;
        this.descricaoUsoVeiculo = descricaoUsoVeiculo;
        this.veiculo = veiculo;
        this.clientes = clientes;
    }

    public Apolice() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getLocaldaPernoite() {
        return localdaPernoite;
    }

    public void setLocaldaPernoite(String localdaPernoite) {
        this.localdaPernoite = localdaPernoite;
    }

    public String getDescricaoUsoVeiculo() {
        return descricaoUsoVeiculo;
    }

    public void setDescricaoUsoVeiculo(String descricaoUsoVeiculo) {
        this.descricaoUsoVeiculo = descricaoUsoVeiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


}
