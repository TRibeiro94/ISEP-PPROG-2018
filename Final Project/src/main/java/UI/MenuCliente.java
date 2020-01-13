package UI;

import static UI.MenuLogin.input;
import Utils.Data;
import Utils.Tempo;
import static Utils.Utilitarios.isNumeric;
import static Utils.Utilitarios.calculoDoCusto;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.lang.System.exit;
import java.time.YearMonth;
import java.util.Calendar;
import model.AplicacaoGPSD;
import model.CodigoPostal;
import model.EnderecoPostal;
import model.PedidoPrestacaoServico;
import model.Servico;


/**
 * @author Tiago Ribeiro (1181444)
 */
public class MenuCliente {

    public MenuCliente() {
    }

    /**
     * Imprime o menu a ser mostrado apenas a Clientes
     */
    public static void mostrarMenuCliente() {
        System.out.println();
        System.out.println("Bem-vindo: " + AplicacaoGPSD.empresa.getDesignacao());
        System.out.println("------------------");
        System.out.println("MENU CLIENTE");
        System.out.println("------------------\n");
        System.out.println("1- (UC6) Efetuar pedido de prestação de serviço\n"
                         + "2- (UC7) Adicionar um endereço à informação de Cliente\n"
                         + "0- Sair");
    }
    
    /**
     * Imprime o menu de Clientes enquanto o Cliente não faz uma escolha válida
     * @param loginEmail e-mail do Cliente que fez login no sistema
     */
    public void loop(String loginEmail) {
        
            String escolha;
            do {
                mostrarMenuCliente();
                escolha = input.nextLine();

                switch (escolha) {
                    case "1":
                        escolhaDeCategoria(loginEmail);
                        break;
                    case "2":
                        adicionarEndereco(loginEmail);
                        break;
                    case "0":
                        gravarFicheiroBinario("registoPedidos.ser");
                        exit(0);
                        break;
                }
            } while (escolha != "0" || isNumeric(escolha) == false);
    }
    
    /**
     * Permite ao Cliente escolher uma Categoria disponível na Empresa, assim como permite o preenchimento
     * dos dados subsequentes necessários para efetuar um Pedido
     * @param loginEmail e-mail do Cliente
     */
    public void escolhaDeCategoria(String loginEmail) {

        String resposta;
        do {
            mostrarCategorias();
            resposta = input.nextLine();

            switch (resposta) {
                case "1":
                    String categoria1 = "cat01";
                    escolhaDeServico(categoria1, loginEmail);
                    break;
                case "2":
                    String categoria2 = "cat02";
                    escolhaDeServico(categoria2, loginEmail);
                    break;
                case "3":
                    String categoria3 = "cat03";
                    escolhaDeServico(categoria3, loginEmail);
                    break;
                case "4":
                    String categoria4 = "cat04";
                    escolhaDeServico(categoria4, loginEmail);
                    break;
                case "5":
                    String categoria5 = "cat05";
                    escolhaDeServico(categoria5, loginEmail);
                    break;
                case "0":
                    break;
            }
        } while (resposta != "0" || isNumeric(resposta) == false);
    }
    
    /**
     * Imprime as Categorias da Empresa
     */
    public void mostrarCategorias() {
        System.out.println("\nSelecione a Categoria que deseja:  (0 para cancelar)\n-------------------------------------------------");
        AplicacaoGPSD.empresa.listarCategorias();
    }
    
    /**
     * Permite ao Cliente escolher um serviço adjacente à categoria que escolheu previamente, assim como os
     * dados subsequentes para efetuar um Pedido
     * @param catID ID da Categoria escolhida previamente
     * @param loginEmail e-mail do Cliente
     */
    public void escolhaDeServico(String catID, String loginEmail){
        System.out.println("\nSelecione o Serviço que deseja:  (0 para cancelar)\n-------------------------------------------------");
        String resposta;
        
        do{
            AplicacaoGPSD.empresa.listarServicosByCatID(catID);
            resposta = input.nextLine();
            
            switch (resposta){
                case "1":
                    Servico s1 = AplicacaoGPSD.empresa.getServicoByEscolhaServico(catID, Integer.parseInt(resposta));
                    System.out.println("\n");
                    escolhaDeHorarioEnderecoEtarefa(loginEmail, s1);
                    break;
                case "2":
                    Servico s2 = AplicacaoGPSD.empresa.getServicoByEscolhaServico(catID, Integer.parseInt(resposta));
                    System.out.println("\n");
                    escolhaDeHorarioEnderecoEtarefa(loginEmail, s2);
                    break;
                case "3":
                    Servico s3 = AplicacaoGPSD.empresa.getServicoByEscolhaServico(catID, Integer.parseInt(resposta));
                    System.out.println("\n");
                    escolhaDeHorarioEnderecoEtarefa(loginEmail, s3);
                    break;
                case "0":
                    break;
            }
        } while (resposta != "0" || isNumeric(resposta) == false);
    }
    
    /**
     * Possibilita o Cliente de escolhar data e horário para o serviço que deseja, assim como uma breve descrição
     * da tarefa. Tem a hipótese de confirmar ou cancelar no fim o pedido com o seu custo já também calculado
     * @param loginEmail e-mail do Cliente
     * @param servico serviço escolhido pelo Cliente
     */
    public void escolhaDeHorarioEnderecoEtarefa(String loginEmail, Servico servico){
        
        System.out.println("\nData para o pedido:\n-----------------------");
        Data data = escolhaDeData();
        
        System.out.println("\nHorário para início do pedido: (apenas hora)\n--------------------------------");
        Tempo horaInicio = escolhaHoraInicio();
        
        System.out.println("\nHorário para término do pedido: (apenas hora)\n--------------------------------");
        Tempo horaFim = escolhaHoraFim(horaInicio);
        
        double valorCustoTotal = calculoDoCusto(horaInicio.getHoras(), horaFim.getHoras(), servico.getCustoHora());
        String descricaoTarefa = descreverTarefa();
        
        System.out.println("Selecione o Endereço (número no topo) onde deseja ver o seu pedido ser executado:\n");
        EnderecoPostal end = new EnderecoPostal(escolherEnderecoParaPrestacao(loginEmail));
        
        System.out.println("\nConfirme o seguinte Pedido(S/N):\n");
        
        PedidoPrestacaoServico pedido = new PedidoPrestacaoServico(servico, data, horaInicio, horaFim, descricaoTarefa, valorCustoTotal, end);
        System.out.println(pedido);
        
        String resposta = input.nextLine();
        
        if(resposta.equalsIgnoreCase("s")){
            
            AplicacaoGPSD.empresa.adicionarPedido(pedido);
            
            MenuCliente m = new MenuCliente();
            m.loop(loginEmail);
            
        }else if(resposta.equalsIgnoreCase("n")){
            
            MenuCliente m = new MenuCliente();
            m.loop(loginEmail);
            
        }else{
            System.out.println("\n\nInseriu uma resposta inválida. Por favor efetue novamente o seu pedido e certifique-se que insere uma resposta válida.\n\n");
            MenuCliente m = new MenuCliente();
            m.loop(loginEmail);
        }
    }

    /**
     * Possibilita o Cliente de inserir a data que deseja ver o seu pedido ser executado
     * (ano , mes, dia)
     * @return Data que deseja ver o seu pedido ser executado
     */
    public Data escolhaDeData() {

        Calendar calendario = Calendar.getInstance();

        System.out.println("Ano:");
        String ano = input.nextLine();

        while (isNumeric(ano) == false || (Integer.parseInt(ano) < calendario.get(Calendar.YEAR))) {
            System.out.println("Ano inválido. Tente de novo:");
            ano = input.nextLine();
        }
        int anoInicio = Integer.parseInt(ano);

        System.out.println("Mês:");
        String mes = input.nextLine();

        while (isNumeric(mes) == false || (anoInicio == calendario.get(Calendar.YEAR) && (Integer.parseInt(mes) < (calendario.get(Calendar.MONTH) + 1))) || (Integer.parseInt(mes) > 12) || (Integer.parseInt(mes) <= 0)) {
            System.out.println("Mês inválido. Tente de novo:");
            mes = input.nextLine();
        }
        int mesInicio = Integer.parseInt(mes);
        
        YearMonth anoMes = YearMonth.of(anoInicio, mesInicio);
        int diasMes = anoMes.lengthOfMonth();

        System.out.println("Dia:");
        String dia = input.nextLine();

        while (isNumeric(dia) == false || (Integer.parseInt(dia) > diasMes) || (anoInicio == calendario.get(Calendar.YEAR) && mesInicio == (calendario.get(Calendar.MONTH) + 1) && (Integer.parseInt(dia) < calendario.get(Calendar.DAY_OF_MONTH))) || (Integer.parseInt(dia) <= 0)) {
            System.out.println("Dia inválido. Tente de novo:");
            dia = input.nextLine();
        }
        int diaInicio = Integer.parseInt(dia);

        return new Data(anoInicio, mesInicio, diaInicio);
    }
    
    /**
     * Possibilita o Cliente de inserir a hora de inicio do seu pedido de serviço
     * @return hora de inicio do seu pedido de serviço
     */
    public Tempo escolhaHoraInicio() {

        String inicio = input.nextLine();
        while (isNumeric(inicio) == false || Integer.parseInt(inicio) > 24 || Integer.parseInt(inicio) <= 0) {
            System.out.println("Hora inválida. Tente de novo(formato 24h):");
            inicio = input.nextLine();
        }
        int horaInicio = Integer.parseInt(inicio);

        return new Tempo(horaInicio);
    }
    
    /**
     * Possibilita o Cliente de inserir a hora de fim do seu pedido de serviço
     * @param horaInicio hora de inicio que foi introduzida previamente
     * @return hora de fim do seu pedido de serviço
     */
    public Tempo escolhaHoraFim(Tempo horaInicio) {
        
        String fim = input.nextLine();
        
        while (isNumeric(fim) == false || Integer.parseInt(fim) > 24 || (Integer.parseInt(fim) <= 0) || Integer.parseInt(fim) <= horaInicio.getHoras()) {
            System.out.println("Hora inválida. Tente de novo:");
            fim = input.nextLine();
        }
        int horaFim = Integer.parseInt(fim);

        return new Tempo(horaFim);
    }
    
    /**
     * Permite ao Cliente descrever a tarefa que pretende ver executada 
     * @return descriçao da tarefa
     */
    public String descreverTarefa(){
        
        System.out.println("\nFaça uma breve descrição da tarefa que pretende que seja executada:");
        String descricao = input.nextLine();
        
        return descricao;
    }
    
    /**
     * Grava um ficheiro binário onde são serializados os pedidos de prestação de serviço
     * @param nomeFicheiro nome do ficheiro a ler
     * @return true, se o ficheiro foi gravado com sucesso
     *         false, se o ficheiro não foi gravado
     */
    public boolean gravarFicheiroBinario(String nomeFicheiro) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            try {
                out.writeObject(AplicacaoGPSD.empresa.getListaPedidos());
            } finally {
                out.close();
            }
            return true;
        } catch (IOException ex) {
            System.out.println("Não foi possível gravar no ficheiro de Pedidos de Prestação de Serviço.");
            ex.printStackTrace();
            System.out.println("\n");
            return false;
        }
    }
    
    /**
     * Permite ao Cliente escolher o Endereço em que deseja que o seu pedido seja executado
     * @param loginEmail e-mail do Cliente
     * @return Endereço que o cliente deseja que o seu pedido seja executado
     */
    public EnderecoPostal escolherEnderecoParaPrestacao(String loginEmail){
        
        AplicacaoGPSD.empresa.getClienteByEmail(loginEmail).listarEnderecos();
        String escolhaDeEndereco = input.nextLine();
        
        if(isNumeric(escolhaDeEndereco) == false || AplicacaoGPSD.empresa.getClienteByEmail(loginEmail).getEnderecoByNumero(Integer.parseInt(escolhaDeEndereco)) == null){
          do{
          System.out.println("\nInsira um valor referente a um endereço válido.");
          escolhaDeEndereco = input.nextLine();
          } while(isNumeric(escolhaDeEndereco) == false || AplicacaoGPSD.empresa.getClienteByEmail(loginEmail).getEnderecoByNumero(Integer.parseInt(escolhaDeEndereco)) == null);
        }
        
        int escolha = Integer.parseInt(escolhaDeEndereco);
        return AplicacaoGPSD.empresa.getClienteByEmail(loginEmail).getEnderecoByNumero(escolha);
    }
    
    /**
     * Permite ao Cliente adicionar um endereço à sua ficha de Cliente de modo a poder fazer pedidos para o mesmo
     * @param loginEmail e-mail do Cliente
     * @return mensagem de sucesso da operação
     */
    public void adicionarEndereco(String loginEmail){
        System.out.println("\nAdicionar endereço:\n------------------------------");
        
        System.out.println("Insira a morada:");
        String morada = input.nextLine();
        
        System.out.println("\nInsira a localidade:");
        String localidade = input.nextLine();
        
        System.out.println("\nInsira o código-postal:");
        String codPostal = input.nextLine();
        
        System.out.println("\nInsira a latitude do código-postal:");
        String latitude = input.nextLine();
        
        System.out.println("\nInsira a longitude do código-postal:");
        String longitude = input.nextLine();
        
        System.out.println("\nConfirme o endereço que está prestes a adicionar:(S/N)\n" +morada+ "/" +localidade+ "/" +codPostal);
        String resposta = input.nextLine();
        
        if(resposta.equalsIgnoreCase("s")){
            
            EnderecoPostal novoEndereco = new EnderecoPostal(morada, localidade, new CodigoPostal(codPostal, latitude, longitude));
            
            AplicacaoGPSD.empresa.getClienteByEmail(loginEmail).adicionarEndereco(novoEndereco);
            System.out.println("\nO endereço foi adicionado com sucesso.\n");
            
            MenuCliente m = new MenuCliente();
            m.loop(loginEmail);
            
        }else if(resposta.equalsIgnoreCase("n")){
            
            MenuCliente m = new MenuCliente();
            m.loop(loginEmail);
            
        }else{
            System.out.println("\n\nInseriu uma resposta inválida. Por favor efetue novamente a associação de um endereço e certifique-se que insere uma resposta válida.\n\n");
            MenuCliente m = new MenuCliente();
            m.loop(loginEmail);
        }
    }
}