package project2;

/**
 *
 * @author Tiago Soares (1181444)
 */
public class AtletaAmador extends AtletaNaoPro {
    /**
     * percentagem dos valores em prémios arrecadados (7%)
     */
    private static final double VALORPERCENTAGEM2 = 0.07;
    /**
     * valor mínimo de vencimento de um atleta amador (5€)
     */
    private static final int VALORMINIMO = 5;

    /**
     * Constrói uma instância de AtletaAmador que recebe nome, número de
     * identificação civil, género, idade atividade desportiva, FCR, valor
     * arrecadado em prémios e antiguidade do atleta no clube
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
    }
     /**
     * Constrói uma instância de AtletaAmador que é cópia de uma instância AtletaAmador passada por parâmetro
     * 
     * @param outroAtletaAmador AtletaAmador que vai ser 'copiado' 
     */
    public AtletaAmador(AtletaAmador outroAtletaAmador) {
        super(outroAtletaAmador);
    }    

    /**
     * Constrói uma instância de AtletaAmador com valores por omissão
     */
    public AtletaAmador() {
        super();
    }

    /**
     * Devolve as características do atleta amador, assim como a sua antiguidade
     * no clube
     *
     * @return características do atleta amador, assim como a sua antiguidade no
     * clube
     */
    @Override
    public String toString() {
        return String.format("%s - Atleta Amador com %d anos de casa", super.toString(), getAntiguidade());
    }

    /**
     * Calcula o valor a pagar a atleta
     *
     * @return valor a pagar ao atleta
     */
    @Override
    public double calcularPagamento() {
        if (calcularParcelaVariavel() + calcularParcelaVariavel2() < VALORMINIMO) {
            return (VALORMINIMO);
        }
        return calcularParcelaVariavel() + calcularParcelaVariavel2();
    }

    /**
     * Calcula o valor da segunda parcela variável de vencimento do atleta
     *
     * @return valor da parcela variável de vencimento
     */
    public double calcularParcelaVariavel2() {
        return getValorMensal() * VALORPERCENTAGEM2;
    }

    /**
     * Devolve o valor da percentagem dos valores arrecadados em prémios
     *
     * @return valor da percentagem dos valores arrecadados em prémios
     */
    public double getValorPercentagem2() {
        return VALORPERCENTAGEM2;
    }

    /**
     * Devolve o valor mínimo de vencimento de amadores
     *
     * @return valor minimo de vencimento de amadores
     */
    public double getValorMinimo() {
        return VALORMINIMO;
    }
}
