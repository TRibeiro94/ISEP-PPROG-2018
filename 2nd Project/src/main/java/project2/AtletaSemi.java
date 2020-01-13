package project2;

/**
 *
 * @author Tiago Soares (1181444)
 */
public class AtletaSemi extends AtletaNaoPro implements DescontoIRS {

    /**
     * parcelaFixa de vencimento de um atleta semiprofissional, valor igual para todos.
     */
    private static double parcelaFixa = 100;

    /**
     * Constrói uma instância de AtletaNaoPro que recebe nome, número de
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
    public AtletaSemi(String nome, int numCC, String genero, int idade, String atividade, int FCR, double valorMensal, int antiguidade) {
        super(nome, numCC, genero, idade, atividade, FCR, valorMensal, antiguidade);
    }
    /**
     * Constrói uma instância de AtletaSemi que é cópia de uma instância AtletaSemi passada por parâmetro
     * 
     * @param outroAtletaSemi AtletaSemi que vai ser 'copiado' 
     */
    public AtletaSemi (AtletaSemi outroAtletaSemi){
        super(outroAtletaSemi);
    }
    /**
     * Constrói uma instância de AtletaNaoPro com valores por omissão
     */
    public AtletaSemi() {
        super();
    }

    /**
     * Devolve as características do atleta semiprofissional, assim como a sua
     * antiguidade no clube
     *
     * @return características do atleta semiprofissional, assim como a sua
     * antiguidade no clube
     */
    @Override
    public String toString() {
        return String.format("%s - Atleta Semi Profissional com %d anos de casa", super.toString(), getAntiguidade());
    }

    /**
     * Calcula o valor a pagar a atleta
     *
     * @return valor a pagar ao atleta
     */
    @Override
    public double calcularPagamento() {
        return calcularParcelaVariavel() + parcelaFixa - valorDoDesconto();
    }

    /**
     * Calcula o valor do doesconto, incidente sobre a parcela fixa, destinado
     * ao IRS
     *
     * @return valor do doesconto destinado ao IRS
     */
    @Override
    public double valorDoDesconto() {
        return parcelaFixa * taxaImutavelIRS;
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
     * Modifica o valor da parcela fixa de vencimento
     *
     * @param parcelaFixa valor da parcela fixa de vencimento
     */
    public void setParcelaFixa(double parcelaFixa) {
        this.parcelaFixa = parcelaFixa;
    }
}
