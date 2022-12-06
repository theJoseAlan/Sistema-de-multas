package br.com.mildevs.entity;

import jakarta.persistence.*;

@Entity
public class Multa {

    @Id
    @Column(name = "cod_Multa")
    private int codMulta;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int pontuacao;

    @ManyToOne
    @JoinColumn(name = "placa_fk", referencedColumnName = "placa")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "cnh_fk", referencedColumnName = "num_cnh")
    private Condutor condutor;

    public int getCodMulta() {
        return codMulta;
    }

    public void setCodMulta(int codMulta) {
        this.codMulta = codMulta;
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }
}
