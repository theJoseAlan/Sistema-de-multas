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
    public List<Multa> listaMultas(){
        Query query = manager.createQuery("Select m FROM Multa as m");
        return query.getResultList();
    }

    //Consulta
    public Multa consultaMulta(int codMulta){
        return this.manager.find(Multa.class, codMulta);
    }

    //Remoção
    public boolean removeMulta(int codMulta){
        Multa multa = this.manager.find(Multa.class, codMulta);

        if(multa==null){
            return false;
        }
        this.manager.getTransaction().begin();
        this.manager.remove(multa);
        this.manager.getTransaction().commit();

        return true;
    }

    //Adciona Veiculo
    public boolean adcionaVeiculo(Multa multa, String placa) {

        Veiculo veiculo = this.manager.find(Veiculo.class, placa);

        multa.setVeiculo(veiculo);

        this.manager.getTransaction().begin();
        this.manager.persist(multa);
        this.manager.getTransaction().commit();

        return true;

    }

    //Adciona Veiculo
    public boolean adcionaCondutor(Multa multa, int cnh) {

        Condutor condutor = this.manager.find(Condutor.class, cnh);

        multa.setCondutor(condutor);

        this.manager.getTransaction().begin();
        this.manager.persist(multa);
        this.manager.getTransaction().commit();

        return true;

    }



}
