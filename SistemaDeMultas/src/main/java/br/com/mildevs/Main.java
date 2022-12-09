package br.com.mildevs;

import br.com.mildevs.dao.CondutorDao;
import br.com.mildevs.dao.MultaDao;
import br.com.mildevs.dao.VeiculoDao;
import br.com.mildevs.entity.Condutor;
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
        condutor.setDataEmissao("12/12/12");
        condutor.setOrgaoEmissor("CCXP");
        condutorDao.criaCondutor(condutor);

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("BMX");
        veiculo.setModelo("Bike Discorvernant");
        veiculo.setPlaca("TEC3212");
        //veiculo.setCondutor(condutor);

        veiculoDao.criaVeiculo(veiculo);
        veiculoDao.insereCondutor(condutor, veiculo.getPlaca());


        /*
        Multa multa = new Multa();
        multa.setCodMulta(12);
        multa.setPontuacao(3);
        multa.setValor(300.45);
        multa.setVeiculo(veiculo);
        multa.setCondutor(condutor);
        multaDao.criaMulta(multa);


        condutorDao.adcionaPontos(condutor.getNumCnh(), multa.getPontuacao());

        Multa multa2 = new Multa();
        multa2.setCodMulta(11);
        multa2.setPontuacao(5);
        multa2.setValor(543);
        multa2.setVeiculo(veiculo);
        multa2.setCondutor(condutor);
        multaDao.criaMulta(multa2);

        condutorDao.adcionaPontos(condutor.getNumCnh(), multa2.getPontuacao());

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


    private static void exibeMenuPrincipal() {
        System.out.println("=============== SISTEMA DE MULTAS ===============");
        System.out.println("                     _______      \n" +
                "                    //  ||\\ \\     \n" +
                "              _____//___||_\\ \\___ \n" +
                "              )  _          _    \\\n" +
                "              |_/ \\________/ \\___|\n" +
                "             ___\\_/________\\_/____");
        System.out.println("================= SEJA BEM-VINDO =================");
        System.out.println("\nEscolha uma das opções para manipulação: ");
        System.out.println("[1] CONDUTOR | [2] VEICULO | [3] MULTA [4] SAIR\nR: ");
    }

    private static void exibeSubmenu() {
        System.out.println("O que deseja fazer?");
        System.out.print("[1] Inserir\n[2] Listar todos os cadastros\n" +
                        "[3] Consultar um cadastro\n[4] Remover um cadastro\n" +
                        "obs.: Digite qualquer outro numero para voltar ao MENU PRINCIPAL\nR: ");
    }
}