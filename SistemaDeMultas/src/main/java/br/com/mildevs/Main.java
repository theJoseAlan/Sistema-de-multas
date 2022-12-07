package br.com.mildevs;

import br.com.mildevs.dao.CondutorDao;
import br.com.mildevs.dao.MultaDao;
import br.com.mildevs.dao.VeiculoDao;
import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Multa;
import br.com.mildevs.entity.Veiculo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CondutorDao condutorDao = new CondutorDao();
        VeiculoDao veiculoDao = new VeiculoDao();
        MultaDao multaDao = new MultaDao();


        Condutor condutor = new Condutor();
        condutor.setNumCnh(12345);
        condutor.setDataEmissao("04/12/09");
        condutor.setOrgaoEmissor("SSPX");
        condutorDao.criaCondutor(condutor);


        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("BMW");
        veiculo.setModelo("Bem grande");
        veiculo.setPlaca("OCK6635");
        veiculo.setCondutor(condutor);
        veiculoDao.criaVeiculo(veiculo);

        Multa multa = new Multa();
        multa.setCodMulta(12);
        multa.setPontuacao(3);
        multa.setValor(300.45);
        multa.setVeiculo(veiculo);
        multa.setCondutor(condutor);
        //condutorDao.adcionaPontos(multa, multa.getPontuacao());
        multaDao.criaMulta(multa);

        /*
        Multa multa2 = new Multa();
        multa2.setCodMulta(11);
        multa2.setPontuacao(5);
        multa2.setValor(543);
        multa2.setVeiculo(veiculo);
        multa2.setCondutor(condutor);
        multaDao.criaMulta(multa2);
        */


        /*
        //Consulta

        Condutor condutorBd = condutorDao.consultaCondutor(12345);
        System.out.println("Condutor encontrado = > "+condutorBd);
        */

/*
        //listagem
        System.out.println("\n====== CONDUTORES ENCONTRADOS ======");
        System.out.println("ANTES DA REMOÇÂO");
        List<Condutor> condutoresNoBd = condutorDao.listaCondutores();
        for (Condutor listaCondutores : condutoresNoBd){
            System.out.println(listaCondutores);
        }

        /*
        //Remoção

        System.out.println("DEPOIS DA REMOÇÂO");
        condutorDao.removeCondutor(12345);
        List<Condutor> condutoresNoBd2 = condutorDao.listaCondutores();
        for (Condutor listaCondutores : condutoresNoBd2){
            System.out.println(listaCondutores);
        }
        */

    }

    private static void exibeSubmenu() {
        System.out.println("O que deseja fazer?");
        System.out.print("[1] Inserir\n[2] Listar todos os cadastros\n" +
                        "[3] Consultar um cadastro\n[4] Remover um cadastro\n" +
                        "obs.: Digite qualquer outro numero para voltar ao MENU PRINCIPAL\nR: ");
    }
}