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

    /*
    public boolean adcionaPontos(int cnh, int pontos){
        Condutor condutor = this.manager.find(Condutor.class, cnh);


        condutor.setPontuacao(condutor.getPontuacao()+pontos);

        this.manager.getTransaction().begin();
        this.manager.persist(condutor);
        this.manager.getTransaction().commit();

        return true;
    }
     */

    public boolean insereCondutor(Condutor condutor, String placa){
        Veiculo veiculo = this.manager.find(Veiculo.class, placa);

        if (veiculo==null){
            return false;
        }

        if (veiculo.getCondutor()!=null){
            return false;
        }

        veiculo.setCondutor(condutor);
        this.manager.getTransaction().begin();
        this.manager.merge(veiculo);
        this.manager.getTransaction().commit();

        return true;
    }

    /*Venda Veiculo
    public boolean vendaVeiculo(){
        return true;
    }

   public int retornaCnh(Veiculo veiculo){

        Condutor condutor;

        condutor = manager.find(Condutor.class, veiculo.getCondutor());

        return condutor.getNumCnh();

    }*/


}
