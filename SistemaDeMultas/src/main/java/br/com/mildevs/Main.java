package br.com.mildevs;

import br.com.mildevs.dao.CondutorDao;

import br.com.mildevs.dao.MultaDao;
import br.com.mildevs.dao.VeiculoDao;
import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Multa;
import br.com.mildevs.entity.Veiculo;
import com.sun.source.tree.SwitchTree;
import jakarta.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF); //Limpa os codigos warnings no hibernate

        Scanner input = new Scanner(System.in);
        CondutorDao condutorDao = new CondutorDao();
        VeiculoDao veiculoDao = new VeiculoDao();
        MultaDao multaDao = new MultaDao();

        int sop;

        do {

            exibeMenuPrincipal();
            int op = input.nextInt();

            if(op==1){
                do {

                    System.out.println("=-=-=- CONDUTOR -=-=-=");
                    exibeSubmenu();
                    sop = input.nextInt();

                    switch (sop){
                        case 1:
                            insereCondutor(input, condutorDao);
                            break;

                        case 2:
                            ListaCondutores(condutorDao);
                            break;

                        case 3:
                            ConsultaCondutor(input, condutorDao);
                            break;

                        case 4:
                            removeCondutor(input, condutorDao);
                            break;

                        default:
                            break;
                    }
                    if (sop==5){
                        break;
                    }
                }while (true);

            } else if (op==2) {
                do {
                    System.out.println("=-=-=- VEICULO -=-=-=");
                    exibeSubmenuVeiculo();
                    sop = input.nextInt();
                    input.nextLine();

                    switch (sop){
                        case 1:
                            insereVeiculo(input, veiculoDao);
                            break;

                        case 2:
                            listaVeiculos(veiculoDao);
                            break;

                        case 3:
                            consultaVeiculo(input, veiculoDao);
                            break;

                        case 4:
                            removeVeiculo(input, veiculoDao);
                            break;

                        case 5:
                            System.out.print("Placa do veiculo: ");
                            String placa = input.nextLine();
                            System.out.print("CNH do comprador: ");
                            int cnh = input.nextInt();
                            input.nextLine();

                            veiculoDao.vendaVeiculo(placa, cnh);

                            System.out.println("Veiculo com placa "+placa+" vendido para comprador com cnh "+cnh);

                        default:
                            break;
                    }
                    if (sop==6){
                        break;
                    }

                }while (true);

            } else if (op==3) {
                do {
                    System.out.println("=-=-=- MULTA -=-=-=");
                    exibeSubmenu();
                    sop = input.nextInt();
                    input.nextLine();

                    switch (sop) {
                        case 1:
                            insereMulta(input, condutorDao, multaDao);
                            break;

                        case 2:
                            listaMultas(multaDao);
                            break;

                        case 3:
                            consultaMultas(input, multaDao);
                            break;

                        case 4:
                            removeMulta(input, multaDao);
                            break;

                        /*case 5:
                            System.out.print("Placa do veiculo: ");
                            String placa = input.nextLine();
                            multaDao.listaMultasPorVeiculo(placa);

                            break;*/

                        default:
                            break;
                    }

                    if (sop==5){
                        break;
                    }

                }while (true);

            } else if (op==4) {
                exibeFim();
                break;
            }

        }while (true);
    }

    private static void removeMulta(Scanner input, MultaDao multaDao) {
        System.out.print("Digite o código da multa que deseja remover: ");
        int multaARemover = input.nextInt();
        input.nextLine();

        System.out.print("Tem certeza que deseja remover a multa" +
                " com CÓDIGO = "+multaARemover+" ? [S] SIM [N] NÂO\nR: ");
        String  certeza = input.nextLine();

        if(certeza.equals("S") || certeza.equals("s")){
            multaDao.removeMulta(multaARemover);
            System.out.println("MULTA REMOVIDA");
        } else {
            System.out.println("MULTA MANTIDA");
        }
    }

    private static void consultaMultas(Scanner input, MultaDao multaDao) {
        System.out.println("========= CONSULTA ===========");
        System.out.print("Digite o código da multa que deseja consultar: ");
        int multaAConsultar = input.nextInt();

        Multa multaBd = multaDao.consultaMulta(multaAConsultar);
        System.out.println("Multa encontrada = > "+multaBd);
    }

    private static void listaMultas(MultaDao multaDao) {
        List<Multa> multasnoBd = multaDao.listaMultas();
        System.out.println("========= LISTA MULTAS ===========");
        for(Multa multasEncontradas : multasnoBd) {
            System.out.println(multasEncontradas);
        }
    }

    private static void insereMulta(Scanner input, CondutorDao condutorDao, MultaDao multaDao) {
        System.out.print("Código da multa: ");
        int codMulta = input.nextInt();
        System.out.print("Pontos: ");
        int pontos = input.nextInt();
        System.out.print("Valor: ");
        double valor =  input.nextDouble();
        input.nextLine();
        System.out.print("Placa do veiculo: ");
        String placa = input.nextLine();
        System.out.print("CNH do condutor: ");
        int cnh = input.nextInt();

        Multa multa = new Multa();
        multa.setCodMulta(codMulta);
        multa.setPontuacao(pontos);
        multa.setValor(valor);
        multaDao.criaMulta(multa);
        multaDao.adcionaVeiculo(multa, placa);
        condutorDao.adcionaPontos(cnh, multa.getPontuacao());
        multaDao.adcionaCondutor(multa, cnh);
    }

    private static void removeVeiculo(Scanner input, VeiculoDao veiculoDao) {
        System.out.print("Digite a placa do veículo que deseja remover: ");
        String placaARemover = input.nextLine();

        System.out.print("Tem certeza que deseja remover o veiculo" +
                " com PLACA = "+placaARemover+" ? [S] SIM [N] NÂO\nR: ");
        String  certeza = input.nextLine();

        if(certeza.equals("S") || certeza.equals("s")){
            veiculoDao.removeVeiculo(placaARemover);
            System.out.println("VEICULO REMOVIDO");
        } else {
            System.out.println("VEICULO MANTIDO");
        }
    }

    private static void consultaVeiculo(Scanner input, VeiculoDao veiculoDao) {
        System.out.print("Digite a placa do veículo que deseja consultar: ");
        String placaAConsultar = input.nextLine();
        Veiculo veiculoBd = veiculoDao.consultaVeiculo(placaAConsultar);
        System.out.println("Veiculo encontrado = > "+veiculoBd);
    }

    private static void listaVeiculos(VeiculoDao veiculoDao) {
        List<Veiculo> veiculosnoBd = veiculoDao.listaVeiculo();
        System.out.println("========= LISTA DE VEICULOS ===========");
        for(Veiculo veiculosEncontrados : veiculosnoBd){
        System.out.println(veiculosEncontrados);
        }
    }

    private static void insereVeiculo(Scanner input, VeiculoDao veiculoDao) {
        System.out.print("Placa: ");
        String placa = input.nextLine();
        System.out.print("Marca: ");
        String marca = input.nextLine();
        System.out.print("Modelo: ");
        String modelo = input.nextLine();
        System.out.print("Digite a CNH do condutor deste veículo: ");
        int cnhCondutor = input.nextInt();
        input.nextLine();

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculoDao.criaVeiculo(veiculo);
        veiculoDao.adcionaCondutor(veiculo, cnhCondutor);
    }

    private static void removeCondutor(Scanner input, CondutorDao condutorDao) {
        System.out.print("Digite a CNH do condutor que deseja remover: ");
        int cnhARemover = input.nextInt();
        input.nextLine();

        System.out.print("Tem certeza que deseja remover o condutor" +
                " com CNH = "+cnhARemover+" ? [S] SIM [N] NÂO\nR: ");
        String  certeza = input.nextLine();

        if(certeza.equals("S") || certeza.equals("s")){
            condutorDao.removeCondutor(cnhARemover);
            System.out.println("CONDUTOR REMOVIDO");
        } else {
            System.out.println("CONDUTOR MANTIDO");
        }
    }

    private static void ConsultaCondutor(Scanner input, CondutorDao condutorDao) {
        System.out.print("Digite a CNH do condutor que procura: ");
        int cnhConsulta = input.nextInt();
        Condutor condutorBd = condutorDao.consultaCondutor(cnhConsulta);
        if(condutorBd==null){
            System.out.println("Não foi encontrado nenhum condutor para a CNH: "+cnhConsulta);
        }else{
            System.out.println("Condutor encontrado = > "+condutorBd);
        }
    }

    private static void ListaCondutores(CondutorDao condutorDao) {
        List<Condutor> condutoresnoBd = condutorDao.listaCondutores();
        System.out.println("\n========= LISTA DE CONDUTORES ===========");
        for(Condutor condutoresencontrados : condutoresnoBd){
            System.out.println(condutoresencontrados);
        }
    }

    private static void insereCondutor(Scanner input, CondutorDao condutorDao) {
        System.out.print("CNH: ");
        int cnh = input.nextInt();
        input.nextLine();
        System.out.print("Data de emissão: ");
        String dataEmissao = input.nextLine();
        System.out.print("Orgão emissor: ");
        String orgaoEmissor = input.nextLine();

        Condutor condutor = new Condutor();
        condutor.setNumCnh(cnh);
        condutor.setDataEmissao(dataEmissao);
        condutor.setOrgaoEmissor(orgaoEmissor);
        condutorDao.criaCondutor(condutor);

        System.out.println("Condutor cadastrado!");
    }

    private static void exibeFim() {
        System.out.println("\nAté mais! :-)");
        System.out.println("        .              _._\\\")\n" +
                "        I\\___        ,;)))}^\\\n" +
                "        I `%%^\\%%%%.::q::    `\\.\n" +
                "      .*//*.    OOO  }}} ))    .\\8^8*.\n" +
                "   =JOSE()ALANSALES(((((()'    --(*)--\n" +
                "      \"*oo*\"                   \"*ooo*\"");
    }

    private static void exibeMenuPrincipal() {
        System.out.println("\n\n");
        System.out.println("=============== SISTEMA DE MULTAS ===============");
        System.out.println("                     _______      \n" +
                "                    //  ||\\ \\     \n" +
                "              _____//___||_\\ \\___ \n" +
                "              )  _          _    \\\n" +
                "              |_/ \\________/ \\___|\n" +
                "             ___\\_/________\\_/____");
        System.out.println("================= SEJA BEM-VINDO =================");
        System.out.println("\nEscolha uma das opções para manipulação: ");
        System.out.print("[1] CONDUTOR | [2] VEICULO | [3] MULTA [4] SAIR\nR: ");
    }

    private static void exibeSubmenu() {
        System.out.println("O que deseja fazer?");
        System.out.print("[1] Inserir\n[2] Listar todos os cadastros\n" +
                        "[3] Consultar um cadastro\n[4] Remover um cadastro\n[5] Menu Principal\nR: ");
    }

    private static void exibeSubmenuVeiculo() {
        System.out.println("O que deseja fazer?");
        System.out.print("[1] Inserir\n[2] Listar todos os cadastros\n" +
                "[3] Consultar um cadastro\n[4] Remover um cadastro\n[5] Vender veiculo\n[6] Menu Principal\nR: ");
    }

}