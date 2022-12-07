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

    @OneToMany(mappedBy = "condutor", cascade = CascadeType.ALL)
    private List<Veiculo> veiculo;

    @OneToMany(mappedBy = "codMulta", cascade = CascadeType.ALL)
    private List<Multa> multas;

    @JoinColumn(name = "pontuacao", referencedColumnName = "pontuacao")
    private int pontuacao;

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


    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
