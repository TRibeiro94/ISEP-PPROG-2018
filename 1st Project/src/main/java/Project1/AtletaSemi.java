package Project1;
/**
 *
 * @author Tiago Ribeiro (1181444)
 * @author Pedro Água (1180809)
 */
public class AtletaSemi extends AtletaNaoPro {
    /**
     * parcelaFixa de vencimento de um atleta semiprofissional, valor igual para todos.
     */
    private static double parcelaFixa = 100;
    /**
     * Contador para consultar o número de instâncias de AtletaSemi
     */
    private static int contadorSemi = 0;
    /**
     * Constrói uma instância de AtletaNaoPro que recebe nome, número de identificação civil, género, idade
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
    public AtletaSemi(String nome, int numCC, String genero, int idade, String atividade, int FCR, double valorMensal, int antiguidade) {
        super(nome, numCC, genero, idade, atividade, FCR, valorMensal, antiguidade);
        setParcelaVariavel(calcularParcelaVariavel());
        contadorSemi++;
    }
    /**
     * Constrói uma instância de AtletaNaoPro com valores por omissão
     */
    public AtletaSemi() {
        super();
        contadorSemi++;
    }
    /**
     * Devolve as características do atleta semiprofissional, assim como a sua antiguidade no clube
     * 
     * @return características do atleta semiprofissional, assim como a sua antiguidade no clube
     */
    @Override
    public String toString() {
        return String.format("%s - Atleta Semi Profissional com %d anos de antiguidade"
                + " no Clube Desportivo, aufere de %.2f €.", super.toString(), getAntiguidade(), calcularPagamento());
    }
    /**
     * Calcula o valor a pagar a atleta
     * 
     * @return valor a pagar ao atleta
     */
    @Override
    public double calcularPagamento() {
        return calcularParcelaVariavel() + parcelaFixa;
    }
    /**
     * Calcula a parcela variável de vencimento do atleta
     * 
     * @return parcela variável de vencimento
     */
    @Override
    public double calcularParcelaVariavel() {
        if (getAntiguidade() >= 5 && getAntiguidade() <= 10) {
            return parcelaFixa * 0.02;
        } else if (getAntiguidade() > 10 && getAntiguidade() <= 20) {
            return parcelaFixa * 0.08;
        } else if (getAntiguidade() > 20) {
            return parcelaFixa * 0.2;
        } else
            System.out.println("Antiguidade não está nos devidos parâmetros");
        return 0;
    }
    /**
     * Devolve o valor da parcela fixa de vencimento
     * 
     * @return valor da parcela fixa de vencimento
     */
    public double getParcelaFixa() {
        return parcelaFixa;
    }
    /**
     * Devolve o número de instâncias de AtletaSemi
     * 
     * @return número de instâncias de AtletaSemi
     */
    public double getContadorSemi() {
        return contadorSemi;
    }
    /**
     * Modifica o valor da parcela fixa de vencimento
     * 
     * @param parcelaFixa valor da parcela fixa de vencimento
     */
    public void setParcelaFixa(double parcelaFixa) {
        this.parcelaFixa = parcelaFixa;
    }
}
