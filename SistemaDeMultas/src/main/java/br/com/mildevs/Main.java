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

        int op=0, op2=0;

        do{
            System.out.println("====== SISTEMA DE MULTAS =====");
            System.out.println("Qual das opções abaixo você deseja administrar? ");
            System.out.print("[1] Condutor\n[2] Veículo\n[3] Multa\n[4] Sair\nR: ");

                op = input.nextInt();
                if(op==1){
                    System.out.println("=-=-=- CONDUTORES -=-=-=");

                    exibeSubmenu();

                    op2 = input.nextInt();

                    if(op2==1){

                        System.out.print("CNH: ");
                        int cnh = input.nextInt();
                        input.nextLine();
                        System.out.print("Data de emissão: ");
                        String dataDeEmissao = input.nextLine();
                        System.out.print("Orgão emissor: ");
                        String orgaoEmissor = input.nextLine();
                        System.out.print("Pontuação: ");
                        int pontuacao = input.nextInt();


                        Condutor condutor = new Condutor();
                        condutor.setNumCnh(cnh);
                        condutor.setDataEmissao(dataDeEmissao);
                        condutor.setOrgaoEmissor(orgaoEmissor);
                        condutor.setPontuacao(pontuacao);
                        // condutor.setVeiculo(veiculo);
                        condutorDao.criaCondutor(condutor);
                        System.out.println("Condutor inserido");

                    } else if (op2==2) {

                    }else if (op2==3) {

                    }else if (op2==4) {

                    }

                } else if (op==2) {
                    System.out.println("=-=-=- VEÍCULOS -=-=-=");
                }else if(op==3){
                    System.out.println("=-=-=- MULTAS -=-=-=");
                } else if (op==4) {
                    System.out.println("Até mais!");
                    break;
                }else{
                    System.out.println("Inválido, tente novamente");
                }



        }while (op!=1 || op!=2 || op!=3 || op!=4);



        Condutor condutor2 = new Condutor();
        condutor2.setDataEmissao("12/12/2021");
        condutor2.setNumCnh(54321);
        condutor2.setOrgaoEmissor("SIME");
        condutor2.setPontuacao(90);
        // condutor.setVeiculo(veiculo);
        condutorDao.criaCondutor(condutor2);

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("BMW");
        veiculo.setModelo("Bem grande");
        veiculo.setPlaca("OCK6635");
        //veiculo.setCondutor(condutor);
        veiculoDao.criaVeiculo(veiculo);

        Multa multa = new Multa();
        multa.setCdMulta(12);
        multa.setPontuacao(30);
        multa.setValor(300.45);
        multaDao.criaMulta(multa);

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