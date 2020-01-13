package UI;

import static UI.MenuLogin.input;
import Utils.Data;
import Utils.Tempo;
import static Utils.Utilitarios.isNumeric;
import static java.lang.System.exit;
import java.time.YearMonth;
import java.util.Calendar;
import model.AplicacaoGPSD;
import model.Disponibilidade;

/**
 * @author Tiago Ribeiro (1181444)
 */
public class MenuPrestador {

    public MenuPrestador() {
    }
    
    /**
     * Imprime o menu a ser mostrado apenas a Prestadores de Serviço
     */
    public static void mostrarMenuPrestador() {
        System.out.println();
        System.out.println("Bem-vindo: " + AplicacaoGPSD.empresa.getDesignacao());
        System.out.println("----------------------");
        System.out.println("MENU PRESTADOR");
        System.out.println("----------------------\n");
        System.out.println("1- Indicar Disponibilidade diária de prestação de serviço\n"
                         + "0- Sair\n");
    }
    
    /**
     * Imprime o menu de Prestadores de Serviço enquanto o Prestador não faz uma escolha válida
     * @param loginEmail e-mail do Prestador de Serviço que fez login no sistema
     */
    public void loop(String loginEmail) {
        String escolha;
        do {
            mostrarMenuPrestador();
            escolha = input.nextLine();

            switch (escolha) {
                case "1":
                    inserirDisponibilidade(loginEmail);
                    break;
                case "0":
                    exit(0);
                    break;
            }
        } while (escolha != "0" || isNumeric(escolha) == false);
    }
    
    /**
     * Possibilita o prestador inserir a sua Disponibilidade
     * Depois de pedir data e hora, de inicio e fim, solicita a confirmação dos dados.
     * Se confirmar, é instanciada uma Disponibilidade e adicionada à lista das mesmas
     * Se recusar, é mostrado novamente o menu do Prestador de Serviço
     * @param loginEmail e-mail do Prestador de Serviço que fez login no sistema
     */
    public void inserirDisponibilidade(String loginEmail) {
        
        System.out.println("\nAno de início\n--------------");
        Data dataInicio = dadosDataInicio();

        System.out.println("\nAno de Fim\n--------------");
        Data dataFim = dadosDataFim(dataInicio);

        System.out.println("\nInsira a hora de início do serviço:");
        Tempo horaInicio = dadosHoraInicio();

        System.out.println("\nInsira a hora de fim do serviço:");
        Tempo horaFim = dadosHoraFim(horaInicio);
        
        System.out.println("\nConfirme a seguinte Disponibilidade(S/N):\n");
        
        System.out.println(new Disponibilidade(new Data(dataInicio), new Data(dataFim), new Tempo(horaInicio), new Tempo(horaFim)).toString());
        String confirmacao = input.nextLine();
        
        if(confirmacao.equalsIgnoreCase("s")){
            
            AplicacaoGPSD.empresa.getPrestadorByEmail(loginEmail).adicionarDisponibilidade(new Disponibilidade(new Data(dataInicio), new Data(dataFim), new Tempo(horaInicio), new Tempo(horaFim)));
            
        }else if(confirmacao.equalsIgnoreCase("n")){
            
            loop(loginEmail);
            
        }else{
            
            System.out.println("\nInseriu uma resposta inválida. Insira a sua disponibilidade de novo e confirme se forma válida.");
            MenuPrestador m = new MenuPrestador();
            m.loop(loginEmail);
        }
    }
    
    /**
     * Possibilita o Prestador de inserir a data de inicio da sua Disponibilidade
     * ano , mes, dia
     * @return Data de inicio da disponibilidade
     */
    public Data dadosDataInicio() {

        Calendar calendario = Calendar.getInstance();

        input.nextLine();
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
     * Possibilita o Prestador de inserir a data de fim da sua Disponibilidade
     * @param dataInicio Data de inicio que foi introduzida previamente
     * @return Data de fim de Disponibilidade
     */
    public Data dadosDataFim(Data dataInicio) {

        System.out.println("Ano:");
        String ano = input.nextLine();

        while (isNumeric(ano) == false || (Integer.parseInt(ano) < dataInicio.getAno())) {
            System.out.println("Ano inválido. Tente de novo:");
            ano = input.nextLine();
        }
        int anoFim = Integer.parseInt(ano);

        System.out.println("Mês:");
        String mes = input.nextLine();

        while (isNumeric(mes) == false || (anoFim == dataInicio.getAno() && Integer.parseInt(mes) < dataInicio.getMes()) || (Integer.parseInt(mes) > 12) || (Integer.parseInt(mes) <= 0)) {
            System.out.println("Mês inválido. Tente de novo:");
            mes = input.nextLine();
        }
        int mesFim = Integer.parseInt(mes);
        
        YearMonth anoMes = YearMonth.of(anoFim, mesFim);
        int diasMes = anoMes.lengthOfMonth();

        System.out.println("Dia:");
        String dia = input.nextLine();

        while (isNumeric(dia) == false || (Integer.parseInt(dia) > diasMes) || (anoFim == dataInicio.getAno() && mesFim == dataInicio.getMes() && (Integer.parseInt(dia) < dataInicio.getDia()))) {
            System.out.println("Dia inválido. Tente de novo:");
            dia = input.nextLine();
        }
        int diaFim = Integer.parseInt(dia);

        return new Data(anoFim, mesFim, diaFim);
    }
    
    /**
     * Possibilita o Prestador de inserir a hora de inicio da sua Disponibilidade
     * @return Hora inicio da disponibilidade
     */
    public Tempo dadosHoraInicio() {

        String inicio = input.nextLine();
        while (isNumeric(inicio) == false || Integer.parseInt(inicio) > 24 || Integer.parseInt(inicio) <= 0) {
            System.out.println("Hora inválida. Tente de novo(formato 24h):");
            inicio = input.nextLine();
        }
        int horaInicio = Integer.parseInt(inicio);

        return new Tempo(horaInicio);
    }
    
    /**
     * Possibilita o Prestador de inserir a hora de fim da sua Disponibilidade
     * @param horaInicio hora de inicio que foi introduzida previamente
     * @return hora de fim da disponibilidade
     */
    public Tempo dadosHoraFim(Tempo horaInicio) {
        
        String fim = input.nextLine();
        
        while (isNumeric(fim) == false || Integer.parseInt(fim) > 24 || (Integer.parseInt(fim) <= 0) || Integer.parseInt(fim) <= horaInicio.getHoras()) {
            System.out.println("Hora inválida. Tente de novo:");
            fim = input.nextLine();
        }
        int horaFim = Integer.parseInt(fim);

        return new Tempo(horaFim);
    }
}
