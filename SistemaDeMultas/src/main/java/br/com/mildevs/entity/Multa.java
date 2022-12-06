package br.com.mildevs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Multa {

    @Id
    private int cdMulta;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int pontuacao;

    /*@Column(nullable = false)
    private Veiculo veiculo;*/

    public Multa() {
    }

    public int getCdMulta() {
        return cdMulta;
    }

    public void setCdMulta(int cdMulta) {
        this.cdMulta = cdMulta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
/*
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }*/
}
