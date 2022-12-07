package br.com.mildevs.dao;

import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Multa;
import br.com.mildevs.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class MultaDao {

    private EntityManager manager;

    public MultaDao() {
        this.manager = Persistence.createEntityManagerFactory("multas").createEntityManager();
    }

    //Criação
    public boolean criaMulta(Multa multa){

        this.manager.getTransaction().begin();
        this.manager.persist(multa);
        this.manager.getTransaction().commit();

        return true;
    }

    //Listagem
    public List<Multa> listaMulta(){
        Query query = manager.createQuery("Select m FROM Multa as m");
        return query.getResultList();
    }

    //Adciona os pontos da multa no condutor
    /*public boolean adcionaPontos(Condutor condutor, int pontos){
        Multa multa = this.manager.find(Multa.class, pontos);

        if(multa==null){
            return false;
        }
        if(multa.getCondutor()!=null){
            return false;
        }

        this.manager.getTransaction().begin();
        this.manager.merge(multa);
        this.manager.getTransaction().commit();

        return true;
    }*/

}
