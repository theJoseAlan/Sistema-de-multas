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


    //Venda Veiculo
    public boolean vendaVeiculo(){
        return true;
    }
}
