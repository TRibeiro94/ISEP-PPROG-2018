package UI;

import static UI.MenuLogin.input;
import static Utils.Utilitarios.isNumeric;
import static java.lang.System.exit;
import model.AfetacaoPedidoAPrestador;
import model.AplicacaoGPSD;
import model.PedidoPrestacaoServico;
import model.PrestadorServico;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class MenuAdmin {

    public MenuAdmin() {
    }

    /**
     * Imprime o menu a ser mostrado apenas a Administrativos
     */
    public static void mostrarMenuAdmin() {
        System.out.println();
        System.out.println("Bem-vindo: " + AplicacaoGPSD.empresa.getDesignacao());
        System.out.println("------------------");
        System.out.println("MENU ADMINISTRATIVO");
        System.out.println("------------------\n");
        System.out.println("1- Atribuir Pedido de prestação de serviço a um prestador\n"
                         + "2- Listar Pedidos de prestação de serviço\n"
                         + "0- Sair\n");
    }

    /**
     * Imprime o menu de Administrativos enquanto o Administrativo não faz uma escolha válida
     *
     * @param loginEmail e-mail do Administrativo que fez login no sistema
     */
    public static void loop(String loginEmail) {
        String escolha;
        do {
            mostrarMenuAdmin();
            escolha = input.nextLine();

            switch (escolha) {
                case "1":
                    if (AplicacaoGPSD.empresa.getListaPedidos().size() == 0) {
                        System.out.println("Não existem pedidos de prestação de serviço.");
                    } else {
                        escolherPedido(loginEmail);
                    }
                    break;
                case "2":
                    if (AplicacaoGPSD.empresa.getListaPedidos().size() == 0) {
                        System.out.println("Não existem pedidos de prestação de serviço.");
                    } else {
                        AplicacaoGPSD.empresa.listarPedidos();
                        System.out.println("\n");
                    }
                    break;
                case "0":
                    exit(0);
                    break;
            }
        } while (!escolha.equals("0") || isNumeric(escolha) == false);
    }

    /**
     * Permite ao Administrativo escolher o pedido ao qual deseja atribuir um prestador
     *
     * @param loginEmail e-mail do Administrativo
     */
    public static void escolherPedido(String loginEmail) {
        
        AplicacaoGPSD.empresa.listarPedidos();
        String escolha;
        do{
            System.out.println("\nIntroduza o número do Pedido ao qual deseja associar um Prestador:");
            escolha = input.nextLine();
        } while(isNumeric(escolha) == false || AplicacaoGPSD.empresa.getPedidoByNumero(Integer.parseInt(escolha)) == null);
        
        int pedidoEscolhido = Integer.parseInt(escolha);
        escolherPrestador(AplicacaoGPSD.empresa.getPedidoByNumero(pedidoEscolhido), loginEmail);
    }

    /**
     * Permite ao Administrativo escolher um prestador para ser associado a um pedido
     *
     * @param pedido Pedido de prestação de serviço escolhido pelo Administrativo para associar um prestador ao mesmo
     * @param loginEmail e-mail do Administrativo
     */
    public static void escolherPrestador(PedidoPrestacaoServico pedido, String loginEmail) {
        
        AplicacaoGPSD.empresa.listarPrestadores();
        String escolha;
        
        do{
            System.out.println("\nIntroduza o Prestador (Nrº mecanográfico) que deseja associar ao pedido:\n");
            escolha = input.nextLine();
            
        } while(isNumeric(escolha) == false || AplicacaoGPSD.empresa.getPrestadorByMecanografico(escolha) == null);
        
        efetuarAfetacao(loginEmail, pedido, AplicacaoGPSD.empresa.getPrestadorByMecanografico(escolha));
    }
    
    /**
     * Possibilita o Administrativo de fazer a afetação do prestador a um pedido
     * @param loginEmail e-mail do Administrativo
     * @param pedido Pedido efetuado
     * @param prestador Prestador afetado ao pedido
     */
    public static void efetuarAfetacao(String loginEmail, PedidoPrestacaoServico pedido, PrestadorServico prestador) {

        System.out.println("\nConfirma a seguinte afetação de pedido a um prestador? (S/N)\n");
        System.out.println(new AfetacaoPedidoAPrestador(pedido, prestador));

        String resposta = input.nextLine();

        if (resposta.equalsIgnoreCase("s")) {

            AplicacaoGPSD.empresa.getListaAfetacoes().add(new AfetacaoPedidoAPrestador(pedido, prestador));

        } else if (resposta.equalsIgnoreCase("n")) {

            loop(loginEmail);

        } else {

            System.out.println("\nInseriu uma resposta inválida. Efetue novamente a afetação de um Pedido a um Prestador.");
            loop(loginEmail);
        }
    }
}
