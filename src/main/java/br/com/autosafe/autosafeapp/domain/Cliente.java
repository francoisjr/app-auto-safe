package br.com.autosafe.autosafeapp.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by François on 3/19/2016.
 */
public class Cliente implements Serializable {

    private String id;
    private String nome;
    private String dataNasc;
    private String nomeMae;
    private String rg;
    private String email;
    private String telefone;
    private String celular;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String numHabilatacao;
    private String categoriaHab;
    private String dataEmissaoHab;
    private String dataValidadeHab;
    private String localEmissaoHab;
    private Boolean ehDependente;
    private ArrayList<Apolice> apolices;
    private Login login;

    public Cliente(String id, String nome, String dataNasc, String nomeMae, String rg, String email, String telefone, String celular, String endereco, String bairro, String cidade, String estado, String cep, String numHabilatacao, String categoriaHab, String dataEmissaoHab, String dataValidadeHab, String localEmissaoHab, Boolean ehDependente, ArrayList<Apolice> apolices, Login login) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.nomeMae = nomeMae;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.numHabilatacao = numHabilatacao;
        this.categoriaHab = categoriaHab;
        this.dataEmissaoHab = dataEmissaoHab;
        this.dataValidadeHab = dataValidadeHab;
        this.localEmissaoHab = localEmissaoHab;
        this.ehDependente = ehDependente;
        this.apolices = apolices;
        this.login = login;
    }

    public Cliente() {
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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumHabilatacao() {
        return numHabilatacao;
    }

    public void setNumHabilatacao(String numHabilatacao) {
        this.numHabilatacao = numHabilatacao;
    }

    public String getCategoriaHab() {
        return categoriaHab;
    }

    public void setCategoriaHab(String categoriaHab) {
        this.categoriaHab = categoriaHab;
    }

    public String getDataEmissaoHab() {
        return dataEmissaoHab;
    }

    public void setDataEmissaoHab(String dataEmissaoHab) {
        this.dataEmissaoHab = dataEmissaoHab;
    }

    public String getDataValidadeHab() {
        return dataValidadeHab;
    }

    public void setDataValidadeHab(String dataValidadeHab) {
        this.dataValidadeHab = dataValidadeHab;
    }

    public String getLocalEmissaoHab() {
        return localEmissaoHab;
    }

    public void setLocalEmissaoHab(String localEmissaoHab) {
        this.localEmissaoHab = localEmissaoHab;
    }

    public Boolean getEhDependente() {
        return ehDependente;
    }

    public void setEhDependente(Boolean ehDependente) {
        this.ehDependente = ehDependente;
    }

    public ArrayList<Apolice> getApolices() {
        return apolices;
    }

    public void setApolices(ArrayList<Apolice> apolices) {
        this.apolices = apolices;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ehDependente=" + ehDependente +
                ", localEmissaoHab='" + localEmissaoHab + '\'' +
                ", dataValidadeHab='" + dataValidadeHab + '\'' +
                ", dataEmissaoHab='" + dataEmissaoHab + '\'' +
                ", categoriaHab='" + categoriaHab + '\'' +
                ", numHabilatacao='" + numHabilatacao + '\'' +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", celular='" + celular + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", rg='" + rg + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", dataNasc='" + dataNasc + '\'' +
                ", nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
