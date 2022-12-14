package br.com.mildevs.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Veiculo {

    @Id
    @Column(name = "placa")
    private String placa;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

    @OneToOne
    @JoinColumn(name = "cnh_fk", referencedColumnName = "num_cnh")
    private Condutor condutor;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    //@JoinColumn(name = "multas", referencedColumnName = "cod_Multa") //Add depois
    //@JoinColumn(name = "multas_fk", referencedColumnName = "cod_multa")
    private List<Multa> multas;


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }


    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }


    @Override
    public String toString() {
        return "Placa: " + placa + " | Modelo: " + modelo + " | Marca: " + marca +
                " | Condutor: " + condutor.getNumCnh() + " | Multas: " + multas;
    }
}
