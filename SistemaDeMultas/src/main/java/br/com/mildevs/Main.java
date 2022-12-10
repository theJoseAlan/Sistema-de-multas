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
import java.lang.invoke.StringConcatFactory;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        Scanner input = new Scanner(System.in);
        CondutorDao condutorDao = new CondutorDao();
        VeiculoDao veiculoDao = new VeiculoDao();
        MultaDao multaDao = new MultaDao();



        int sop;

        do {
            exibeMenuPrincipal();
            int op = input.nextInt();

            if(op==1){
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
                        System.out.println("Retornando ao menu principal");
                        break;
                }


            } else if (op==2) {
                System.out.println("=-=-=- VEICULO -=-=-=");
                exibeSubmenu();
                sop = input.nextInt();
                input.nextLine();

                switch (sop){
                    case 1:
                        System.out.print("Placa: ");
                        String placa = input.nextLine();
                        System.out.print("Marca: ");
                        String marca = input.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = input.nextLine();
                        System.out.print("Digite a CNH do condutor deste veículo: ");
                        int cnhCondutor = input.nextInt();

                        Veiculo veiculo = new Veiculo();
                        veiculo.setPlaca(placa);
                        veiculo.setMarca(marca);
                        veiculo.setModelo(modelo);
                        veiculoDao.criaVeiculo(veiculo);

                        veiculoDao.adcionaCondutor(veiculo, cnhCondutor);





                        break;
                }

            } else if (op==3) {
                exibeSubmenu();

            } else if (op==4) {
                exibeFim();
                break;
            }


        }while (true);

/*





        Multa multa = new Multa();
        multa.setCodMulta(12);
        multa.setPontuacao(3);
        multa.setValor(300.45);
        multa.setVeiculo(veiculo);
        multa.setCondutor(condutor);
        multaDao.criaMulta(multa);
        condutorDao.adcionaPontos(condutor.getNumCnh(), multa.getPontuacao());


*/

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
        System.out.println("Condutor encontrado = > "+condutorBd);
    }

    private static void ListaCondutores(CondutorDao condutorDao) {
        List<Condutor> condutoresnoBd = condutorDao.listaCondutores();
        System.out.println("\n========= LISTA CONDUTORES ===========");
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
        System.out.println("\nObrigado por utilizar nossos serviços! :-)");
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
                        "[3] Consultar um cadastro\n[4] Remover um cadastro\n" +
                "OBS.: Digite qualquer outro numero para retornar ao menu principal\nR: ");

    }

}