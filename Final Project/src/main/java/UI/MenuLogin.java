package UI;

import static Utils.Utilitarios.isNumeric;
import static java.lang.System.exit;
import java.util.Scanner;
import model.AplicacaoGPSD;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class MenuLogin {

    public static Scanner input = new Scanner(System.in);

    public MenuLogin() {
    }
    
    /**
     * Imprime o menu inicial a ser mostrado na execução inicial do programa
     */
    public static void mostrarMenuInicial() {
        System.out.println();
        System.out.println("1- Login\n"
                         + "2- Efetuar Registo como Cliente\n"
                         + "0- Sair");
    }
    
    /**
     * Imprime o menu inicial enquanto o utilizador não faz uma escolha válida
     */
    public void loop() {
        String escolha;
        do {
            mostrarMenuInicial();
            escolha = input.nextLine();

            switch (escolha) {
                case "1":
                    login();
                    break;
                case "2":
                    System.out.println("\nEste registo é relativo ao UC1. Não está implementado.\n------------------------------------");
                    break;
                case "0":
                    exit(0);
                    break;
            }
        } while (escolha != "0" || isNumeric(escolha) == false);
    }
    
    /**
     * Solicita e-mail do Utilizador e pede password apenas se o e-mail introduzido
     * corresponder a um utilizador registado. Se o e-mail existir, mostra um menu correspondente
     * ao utilizador que está a efetuar login (Cliente, Prestador ou
     */
    public void login() {
        int maximoTentativas = 3;
        
        System.out.println("\nEmail:");
        
        String loginEmail = input.nextLine();
        
        if (AplicacaoGPSD.empresa.getClienteByEmail(loginEmail) != null) {
            do {
                System.out.println("( " + maximoTentativas + " tentativas )" + " Password:");
                String loginPass = input.nextLine();
                if (loginPass.equalsIgnoreCase(AplicacaoGPSD.empresa.getClienteByEmail(loginEmail).getPassword())) {
                    MenuCliente ui = new MenuCliente();
                    ui.loop(loginEmail);
                    break;
                }
                maximoTentativas--;
            } while (maximoTentativas > 0);
            
        } else if (AplicacaoGPSD.empresa.getPrestadorByEmail(loginEmail) != null) {
            do {
                System.out.println("( " + maximoTentativas + " tentativas )" + " Password:");
                String loginPass = input.nextLine();
                if (loginPass.equalsIgnoreCase(AplicacaoGPSD.empresa.getPrestadorByEmail(loginEmail).getPassword())) {
                    MenuPrestador ui = new MenuPrestador();
                    ui.loop(loginEmail);
                    break;
                }
                maximoTentativas--;
            } while (maximoTentativas > 0);
            
        } else if (AplicacaoGPSD.empresa.getAdminByEmail(loginEmail) != null){
            do{
                System.out.println("( " + maximoTentativas + " tentativas )" + " Password:");
                String loginPass = input.nextLine();
                if (loginPass.equalsIgnoreCase(AplicacaoGPSD.empresa.getAdminByEmail(loginEmail).getPassword())) {
                    MenuAdmin ui = new MenuAdmin();
                    ui.loop(loginEmail);
                    break;
                }
                maximoTentativas--;
            } while (maximoTentativas > 0);
            
        } else {
            System.out.println("Não se encontra registado no sistema. Deseja registar-se? (S/N)");
            String resposta = input.nextLine();
            confirmacao(resposta);
        }
    }
    
    /**
     * Permite ao Utilizador que está a efetuar o Login, que confirme se deseja ou não efetuar registo no sistema
     * @param resposta resposta (sim ou não) do utilizador
     */
    public void confirmacao(String resposta){
        if (resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s")) {
            System.out.println("\nEste registo é relativo ao UC1. Não está implementado.\n------------------------------------");
            loop();
        } else if (resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("n")) {
            loop();
        }else{
            System.out.println("Não inseriu uma resposta válida.");
            loop();
        }
    }
}
