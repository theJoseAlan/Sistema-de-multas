package br.com.mildevs.dao;

import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class VeiculoDao {

    private EntityManager manager;

    public VeiculoDao() {
        this.manager = Persistence.createEntityManagerFactory("multas").createEntityManager();
    }

    //Criação
    public boolean criaVeiculo(Veiculo veiculo){
        this.manager.getTransaction().begin();
        this.manager.persist(veiculo);
        this.manager.getTransaction().commit();

        return true;
    }


    //Listagem
    public List<Veiculo> listaVeiculo(){
        Query query = manager.createQuery("SELECT v FROM Veiculo as v");
        return query.getResultList();
    }

    //consulta
    public Veiculo consultaVeiculo(String placa){
        return this.manager.find(Veiculo.class, placa);
    }

    public boolean adcionaCondutor(Veiculo veiculo, int cnh) {

        Condutor condutor = this.manager.find(Condutor.class, cnh);

       veiculo.setCondutor(condutor);

        this.manager.getTransaction().begin();
        this.manager.persist(veiculo);
        this.manager.getTransaction().commit();

        return true;

    }

    //Remoção
    public boolean removeVeiculo(String placa){
        Veiculo veiculo = this.manager.find(Veiculo.class, placa);

        if(veiculo==null){
            return false;
        }
        this.manager.getTransaction().begin();
        this.manager.remove(veiculo);
        this.manager.getTransaction().commit();

        return true;
    }


/*
    //Venda Veiculo
    public boolean vendaVeiculo(Veiculo veiculo, int cnh) {

        Condutor condutor = this.manager.find(Condutor.class, cnh);

        veiculo.setCondutor(condutor);

        this.manager.getTransaction().begin();
        this.manager.persist(veiculo);
        this.manager.getTransaction().commit();

        return true;

    }*/



}
