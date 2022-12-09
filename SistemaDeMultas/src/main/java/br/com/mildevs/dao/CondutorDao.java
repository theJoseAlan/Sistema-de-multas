package br.com.mildevs.dao;

import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;
import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class CondutorDao {

    private EntityManager manager;

    public CondutorDao() {
       this.manager = Persistence.createEntityManagerFactory("multas").createEntityManager();
    }

    //inserção
    public boolean criaCondutor(Condutor condutor){
        this.manager.getTransaction().begin();
        this.manager.persist(condutor);
        this.manager.getTransaction().commit();

        return true;
    }

    //listagem
    public List listaCondutores(){
        Query query = manager.createQuery("SELECT c FROM Condutor as c");
        return query.getResultList();
    }


    //consulta

    public Condutor consultaCondutor(int cnh){
        return this.manager.find(Condutor.class, cnh);
    }

    //remoção
    public boolean removeCondutor(int cnh){
        Condutor condutor = this.manager.find(Condutor.class, cnh);

        if(condutor==null){
            return false;
        }
        this.manager.getTransaction().begin();
        this.manager.remove(condutor);
        this.manager.getTransaction().commit();

        return true;
    }

    //Adciona pontos

    public boolean adcionaPontos(int cnh, int pontos){
        Condutor condutor = this.manager.find(Condutor.class, cnh);


        condutor.setPontuacao(condutor.getPontuacao()+pontos);

        this.manager.getTransaction().begin();
        this.manager.persist(condutor);
        this.manager.getTransaction().commit();

        return true;
    }



}
