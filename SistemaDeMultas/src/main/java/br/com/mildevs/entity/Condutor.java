package br.com.mildevs.entity;

import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.util.List;

@Entity
public class Condutor{

    @Id
    @Column(name = "num_cnh")
    private int numCnh;

    @Column(nullable = false)
    private String dataEmissao;

    @Column(nullable = false)
    private String orgaoEmissor;

    @Column(nullable = false)
    private int pontuacao;



    //private Veiculo veiculo;

    public int getNumCnh() {
        return numCnh;
    }

    public void setNumCnh(int numCnh) {
        this.numCnh = numCnh;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }


    /*public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }*/

    @Override
    public String toString() {
        return "Condutor{" +
                "numCnh=" + numCnh +
                ", dataEmissao='" + dataEmissao + '\'' +
                ", orgaoEmissor='" + orgaoEmissor + '\'' +
                ", pontuacao=" + pontuacao +
                '}';
    }
}
