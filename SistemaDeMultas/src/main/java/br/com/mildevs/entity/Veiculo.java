package br.com.mildevs.entity;

import jakarta.persistence.*;

import java.util.PrimitiveIterator;

@Entity
public class Veiculo {

    @Id
    private String placa;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

   // @Column
    //private Condutor condutor;


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

/*
    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }*/


}
