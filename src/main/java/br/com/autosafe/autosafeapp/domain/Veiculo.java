package br.com.autosafe.autosafeapp.domain;

import java.io.Serializable;

/**
 * Created by François on 3/19/2016.
 */
public class Veiculo implements Serializable {

    private String id;
    private String modelo;
    private String cor;
    private String chassi;
    private String fabricante;
    private String possuiRastreador;
    private String ano;
    private String placa;
    private String renavam;

    public Veiculo(String id, String modelo, String cor, String chassi, String fabricante, String possuiRastreador, String ano, String placa, String renavam) {
        this.id = id;
        this.modelo = modelo;
        this.cor = cor;
        this.chassi = chassi;
        this.fabricante = fabricante;
        this.possuiRastreador = possuiRastreador;
        this.ano = ano;
        this.placa = placa;
        this.renavam = renavam;
    }

    public Veiculo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPossuiRastreador() {
        return possuiRastreador;
    }

    public void setPossuiRastreador(String possuiRastreador) {
        this.possuiRastreador = possuiRastreador;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", chassi='" + chassi + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", possuiRastreador='" + possuiRastreador + '\'' +
                ", ano='" + ano + '\'' +
                ", placa='" + placa + '\'' +
                ", renavam='" + renavam + '\'' +
                '}';
    }
}
