package Project1;
/**
 *
 * @author Tiago Ribeiro (1181444)
 * @author Pedro Água (1180809)
 */
public class AtletaAmador extends AtletaNaoPro {

    /**
     * segunda parcela variável de vencimento
     */
    private double parcelaVariavel2;
    /**
     * segunda parcela variável de vencimento por omissão
     */
    private static final double PARCELA_VARIAVEL_2_POR_OMISSAO = 0;
    
    /**
     * percentagem dos valores em prémios arrecadados (7%)
     */
    private static double valorPercentagem2 = 0.07;
    /**
     * valor mínimo de vencimento de um atleta amador (5€)
     */
    private static int valorMinimo = 5;
    /**
     * Contador para consultar o número de instâncias de AtletaAmador
     */
    private static int contadorAmador = 0;

        /**
     * Constrói uma instância de AtletaAmador que recebe nome, número de identificação civil, género, idade
     * atividade desportiva, FCR, valor arrecadado em prémios e antiguidade do atleta no clube
     * 
     * @param nome Nome do atleta
     * @param numCC Número de Identificação civil do atleta
     * @param genero Género do atleta
     * @param idade Idade do atleta
     * @param atividade Atividade desportiva do atleta
     * @param FCR Frequência Cardíaca em Repouso do atleta
     * @param valorMensal Valor arrecadado em prémios pelo Atleta
     * @param antiguidade Antiguidade no clube do atleta
     */
    public AtletaAmador(String nome, int numCC, String genero, int idade, String atividade, int FCR, double valorMensal, int antiguidade) {
        super(nome, numCC, genero, idade, atividade, FCR, valorMensal, antiguidade);
        setParcelaVariavel(calcularParcelaVariavel());
        this.parcelaVariavel2 = calcularParcelaVariavel2();
        contadorAmador++;
    }
    /**
     * Constrói uma instância de AtletaAmador com valores por omissão
     */
    public AtletaAmador() {
        super();
        parcelaVariavel2 = PARCELA_VARIAVEL_2_POR_OMISSAO;
        contadorAmador++;
    }
    /**
     * Devolve a segunda parcela variavel de vencimento
     * @return segunda parcela variavel de vencimento
     */
    public double getParcelaVariavel2() {
        return parcelaVariavel2;
    }
    /**
     * Modifica a segunda parcela variavel de vencimento
     * @param parcelaVariavel2 segunda parcela variavel de vencimento
     */
    public void setParcelaVariavel2(double parcelaVariavel2) {
        this.parcelaVariavel2 = parcelaVariavel2;
    }
    /**
     * Devolve as características do atleta amador, assim como a sua antiguidade no clube
     * 
     * @return características do atleta amador, assim como a sua antiguidade no clube
     */
    @Override
    public String toString() {
        return String.format("%s - Atleta Amador com %d anos de antiguidade no Clube Desportivo, aufere de %.2f €.", super.toString(), getAntiguidade(), calcularPagamento());
    }
    /**
     * Calcula o valor a pagar a atleta
     * 
     * @return valor a pagar ao atleta
     */
    @Override
    public double calcularPagamento() {
        if (calcularParcelaVariavel() + calcularParcelaVariavel2() < valorMinimo) {
            return (valorMinimo);
        }
        return calcularParcelaVariavel() + calcularParcelaVariavel2();
    }
    
    /**
     * Calcula a parcela variável de vencimento do atleta
     * 
     * @return parcela variável de vencimento
     */
    @Override
    public double calcularParcelaVariavel() {
        if (getAntiguidade() >= 5 && getAntiguidade() <= 10) {
            return getValorMensal() * 0.02;
        } else if (getAntiguidade() > 10 && getAntiguidade() <= 20) {
            return getValorMensal() * 0.08;
        } else if (getAntiguidade() > 20) {
            return getValorMensal() * 0.2;
        } else {
            System.out.println("Antiguidade não está nos devidos parâmetros.");
        }
        return 0;
    }
        /**
     * Calcula o valor da segunda parcela variável de vencimento do atleta
     * 
     * @return valor da parcela variável de vencimento
     */
    public double calcularParcelaVariavel2() {
        return getValorMensal() * valorPercentagem2;
    }
    /**
     * Devolve o valor da percentagem dos valores arrecadados em prémios
     * @return valor da percentagem dos valores arrecadados em prémios
     */
    public double getValorPercentagem2() {
        return valorPercentagem2;
    }
    /**
     * Devolve o valor mínimo de vencimento de amadores
     * @return valor minimo de vencimento de amadores
     */
    public int getValorMinimo() {
        return valorMinimo;
    }
    /**
     * Devolve o número de instâncias de AtletaAmador
     * 
     * @return número de instâncias de AtletaAmador
     */
    public int getContadorAmador() {
        return contadorAmador;
    }
    /**
     * Modifica o valor da percentagem de valores em prémios
     * @param valorPercentagem2 valor da percentagem de valores em prémios
     */
    public void setValorPercentagem2(double valorPercentagem2) {
        this.valorPercentagem2 = valorPercentagem2;
    }
    /**
     * Modifica o valor mínimo de vencimento de amador
     * 
     * @param valorMinimo valor mínimo de vencimento de amadores
     */
    public void setValorMinimo(int valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

}
